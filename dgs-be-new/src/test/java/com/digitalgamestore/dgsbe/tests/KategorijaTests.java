package com.digitalgamestore.dgsbe.tests;

import com.digitalgamestore.dgsbe.dtos.KategorijaDto;
import com.digitalgamestore.dgsbe.model.Kategorija;
import com.digitalgamestore.dgsbe.model.Korisnik;
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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.SimpleTimeZone;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class KategorijaTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DatabaseLoad databaseLoad;


    @BeforeEach
    protected void cleanup() {
        databaseLoad.getKategorijaRepository().deleteAll();
        databaseLoad.getKorisnikRepository().deleteAll();
        databaseLoad.getUlogaRepository().deleteAll();

    }

    @Test
    public void testGetKategorijas() throws Exception {
        List<Kategorija> kategorijas = databaseLoad.createKategorijas();

        mockMvc.perform(MockMvcRequestBuilders.get("/kategorija/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(Matchers.hasSize(2)));
    }

    @Test
    public void testGetSingleKategorija() throws Exception {
        List<Kategorija> kategorijas = databaseLoad.createKategorijas();
        Integer id = kategorijas.get(0).getId();
        Integer idAdmin = kategorijas.get(0).getAdmin().getId();
        String opis = kategorijas.get(0).getOpisKategorije();
        String naziv = kategorijas.get(0).getNazivKategorije();
        String nazivAdmin = kategorijas.get(0).getAdmin().getKorisnickoIme();

        mockMvc.perform(MockMvcRequestBuilders.get("/kategorija/get/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("idKategorija").value(Matchers.equalTo(id)))
                .andExpect(jsonPath("opisKategorije").value(Matchers.equalTo(opis)))
                .andExpect(jsonPath("nazivKategorije").value(Matchers.equalTo(naziv)))
                .andExpect(jsonPath("idAdmin").value(Matchers.equalTo(idAdmin)))
                .andExpect(jsonPath("nazivAdmin").value(Matchers.equalTo(nazivAdmin)));

    }

    @Test
    public void testGetSingleKategorija_whenDoesntExist() throws Exception {

        try {
            mockMvc.perform(MockMvcRequestBuilders.
                            get("/kategorija/get/{id}", 15000))
                    .andExpect(status().isInternalServerError());
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof NoSuchElementException);
        }
    }

    @Test
    public void testSearchKategorija() throws Exception {
        List<Kategorija> kategorijas = databaseLoad.createKategorijas();
        Integer id = kategorijas.get(1).getId();

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/kategorija/search/naziv2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idKategorija").value(Matchers.equalTo(id)))
                .andExpect(jsonPath("$[0].nazivKategorije").value(Matchers.equalTo("naziv2")));


    }


    @Test
    public void testSearchKategorijas() throws Exception {
        List<Kategorija> kategorijas = databaseLoad.createKategorijas();

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/kategorija/search/naziv").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(Matchers.hasSize(2)));

    }

    @Test
    public void createKategorija() throws Exception {
        Korisnik admin = databaseLoad.createAdmin();

        KategorijaDto kategorijaDto = new KategorijaDto();
        kategorijaDto.setIdAdmin(admin.getId());
        kategorijaDto.setNazivKategorije("nazivnaziv");
        kategorijaDto.setOpisKategorije("opis");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(kategorijaDto );

        mockMvc.perform(MockMvcRequestBuilders.
                        post("/kategorija/create").contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nazivKategorije").value(Matchers.equalTo("nazivnaziv")));

    }
}
