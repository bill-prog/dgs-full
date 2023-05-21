package com.digitalgamestore.dgsbe.controller;

import com.digitalgamestore.dgsbe.dtos.UlogaDto;
import com.digitalgamestore.dgsbe.model.Uloga;
import com.digitalgamestore.dgsbe.service.UlogaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uloga")
public class UlogaController {

    private final UlogaService ulogaService;


    public UlogaController(UlogaService ulogaService) {
        this.ulogaService = ulogaService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<UlogaDto>> getKorisniks()
    {
        List<UlogaDto> ulogaDtos = ulogaService.getAll();
        return ResponseEntity.ok(ulogaDtos);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<UlogaDto> getProizvodac(@PathVariable Long id) {
        Optional<Uloga> uloga = ulogaService.getUlogaById(id);
        return ResponseEntity.ok(new UlogaDto(uloga.get()));
    }
}
