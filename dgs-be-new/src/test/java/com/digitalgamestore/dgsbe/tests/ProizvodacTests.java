package com.digitalgamestore.dgsbe.tests;

import com.digitalgamestore.dgsbe.dtos.ProizvodacDto;
import com.digitalgamestore.dgsbe.model.Proizvodac;
import com.digitalgamestore.dgsbe.utils.DatabaseLoad;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ProizvodacTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DatabaseLoad databaseLoad;


    @BeforeEach
    protected void cleanup() {
        databaseLoad.getKategorijaRepository().deleteAll();
        databaseLoad.getKorisnikRepository().deleteAll();
        databaseLoad.getUlogaRepository().deleteAll();
        databaseLoad.getProizvodacRepository().deleteAll();

    }

    @Test
    public void testGetProizvodacs() throws Exception {
        List<Proizvodac> proizvodacs = databaseLoad.createProizvodacs();

        mockMvc.perform(MockMvcRequestBuilders.get("/proizvodac/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(Matchers.hasSize(2)));
    }

    @Test
    public void testGetSingleProizvodac() throws Exception {
        List<Proizvodac> proizvodacs = databaseLoad.createProizvodacs();
        Integer id = proizvodacs.get(0).getId();


        mockMvc.perform(MockMvcRequestBuilders.get("/proizvodac/get/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("idProizvodac").value(Matchers.equalTo(id)));

    }

    @Test
    public void testGetSingleProizvodac_whenDoesntExist() throws Exception {

        try {
            mockMvc.perform(MockMvcRequestBuilders.
                            get("/proizvodac/get/{id}", 15000))
                    .andExpect(status().isInternalServerError());
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof NoSuchElementException);
        }
    }

    @Test
    public void testSearchProizvodac1() throws Exception {
        List<Proizvodac> proizvodacs = databaseLoad.createProizvodacs();
        Integer id = proizvodacs.get(1).getId();

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/proizvodac/search/Micro").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idProizvodac").value(Matchers.equalTo(id)))
                .andExpect(jsonPath("$[0].nazivProizvodac").value(Matchers.equalTo("Microsoft")));


    }


    @Test
    public void testSearchProizvodac2() throws Exception {
        List<Proizvodac> proizvodacs = databaseLoad.createProizvodacs();
        Integer id = proizvodacs.get(0).getId();

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/proizvodac/search/Ubi").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idProizvodac").value(Matchers.equalTo(id)))
                .andExpect(jsonPath("$[0].nazivProizvodac").value(Matchers.equalTo("Ubisoft")));

    }

    @Test
    public void createProizvodac() throws Exception {

        ProizvodacDto proizvodacDto = new ProizvodacDto();
        proizvodacDto.setNazivProizvodac("Ubisoft");
        proizvodacDto.setGodOsnutka(new Date());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(proizvodacDto);

        mockMvc.perform(MockMvcRequestBuilders.
                        post("/proizvodac/create").contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nazivProizvodac").
                        value(Matchers.equalTo("Ubisoft")));

    }
}
