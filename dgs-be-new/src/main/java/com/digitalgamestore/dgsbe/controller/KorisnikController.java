package com.digitalgamestore.dgsbe.controller;

import com.digitalgamestore.dgsbe.dtos.KorisnikDto;
import com.digitalgamestore.dgsbe.model.Korisnik;
import com.digitalgamestore.dgsbe.service.KorisnikService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/korisnik")
public class KorisnikController {

    private final KorisnikService korisnikService;


    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<KorisnikDto>> getKorisniks()
    {
        List<KorisnikDto> kategorijas = korisnikService.getAll();
        return ResponseEntity.ok(kategorijas);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<KorisnikDto> getKorisnik(@PathVariable Long id) {
        Optional<Korisnik> kategorijas = korisnikService.getKorisnikById(id);
        return ResponseEntity.ok(new KorisnikDto(kategorijas.get()));
    }


}
