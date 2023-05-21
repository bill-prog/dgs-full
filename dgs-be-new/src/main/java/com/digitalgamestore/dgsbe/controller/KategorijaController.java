package com.digitalgamestore.dgsbe.controller;


import com.digitalgamestore.dgsbe.dtos.KategorijaDto;
import com.digitalgamestore.dgsbe.model.Kategorija;
import com.digitalgamestore.dgsbe.service.KategorijaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kategorija")
public class KategorijaController {


    private final KategorijaService kategorijaService;


    public KategorijaController(KategorijaService kategorijaService) {
        this.kategorijaService = kategorijaService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<KategorijaDto>> getKategorija() {
        List<KategorijaDto> kategorijas = kategorijaService.getAll();
        return ResponseEntity.ok(kategorijas);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<KategorijaDto> getKategorija(@PathVariable Long id) {
        Optional<Kategorija> kategorijas = kategorijaService.getKategorijaById(id);
        return ResponseEntity.ok(new KategorijaDto(kategorijas.get()));
    }

    @GetMapping(path = "/search/{text}")
    public ResponseEntity<List<KategorijaDto>> searchKategorija(@PathVariable String text) {
        List<KategorijaDto> kategorijas = kategorijaService.getByText(text);
        return ResponseEntity.ok(kategorijas);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<KategorijaDto> createKategorija(
            @RequestBody KategorijaDto kategorijaDto
    ) {
        return ResponseEntity.ok(kategorijaService.save(kategorijaDto));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteKategorija(
            @PathVariable Long id
    ) {
        kategorijaService.delete(id);
        return ResponseEntity.ok("");
    }


    @PutMapping(path = "/update/{id}")
    public ResponseEntity<KategorijaDto> updateKategorija(
            @PathVariable Long id,
            @RequestBody KategorijaDto kategorijaDto

    ) {
        return ResponseEntity.ok(kategorijaService.update(id, kategorijaDto));
    }
}
