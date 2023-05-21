package com.digitalgamestore.dgsbe.controller;

import com.digitalgamestore.dgsbe.dtos.ProizvodacDto;
import com.digitalgamestore.dgsbe.model.Proizvodac;
import com.digitalgamestore.dgsbe.service.ProizvodacService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proizvodac")
public class ProizvodacController {

    private final ProizvodacService proizvodacService;


    public ProizvodacController(ProizvodacService proizvodacService) {
        this.proizvodacService = proizvodacService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<ProizvodacDto>> getProizvodacs() {
        List<ProizvodacDto> proizvodacDtos = proizvodacService.getAll();
        return ResponseEntity.ok(proizvodacDtos);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<ProizvodacDto> getProizvodac(@PathVariable Long id) {
        Optional<Proizvodac> proizvodac = proizvodacService.getProizvodacById(id);
        return ResponseEntity.ok(new ProizvodacDto(proizvodac.get()));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ProizvodacDto> createProizvodac(
            @RequestBody ProizvodacDto proizvodacDto
    ) {
        return ResponseEntity.ok(proizvodacService.save(proizvodacDto));
    }

    @GetMapping(path = "/search/{text}")
    public ResponseEntity<List<ProizvodacDto>> searchProizvodac(@PathVariable String text) {
        List<ProizvodacDto> kategorijas = proizvodacService.getByText(text);
        return ResponseEntity.ok(kategorijas);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteProizvodac(
            @PathVariable Long id
    ) {
        proizvodacService.delete(id);
        return ResponseEntity.ok("");
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ProizvodacDto> updateProizvodac(
            @PathVariable Long id,
            @RequestBody ProizvodacDto proizvodacDto

    ) {
        return ResponseEntity.ok(proizvodacService.update(id, proizvodacDto));
    }
}
