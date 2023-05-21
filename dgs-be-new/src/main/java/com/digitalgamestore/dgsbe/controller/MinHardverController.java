package com.digitalgamestore.dgsbe.controller;

import com.digitalgamestore.dgsbe.dtos.MinHardverDto;
import com.digitalgamestore.dgsbe.model.MinHardver;
import com.digitalgamestore.dgsbe.service.MinHardverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/minhardver")
public class MinHardverController {

    private final MinHardverService minHardverService;


    public MinHardverController(MinHardverService minHardverService) {
        this.minHardverService = minHardverService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<MinHardverDto>> getMinHardvers()
    {
        List<MinHardverDto> hardverDtos = minHardverService.getAll();
        return ResponseEntity.ok(hardverDtos);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<MinHardverDto> getMinHardver(@PathVariable Long id) {
        Optional<MinHardver> kategorijas = minHardverService.getHardverById(id);
        return ResponseEntity.ok(new MinHardverDto(kategorijas.get()));
    }
}
