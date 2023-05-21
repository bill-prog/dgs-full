package com.digitalgamestore.dgsbe.service;

import com.digitalgamestore.dgsbe.dtos.UlogaDto;
import com.digitalgamestore.dgsbe.model.Uloga;
import com.digitalgamestore.dgsbe.repository.UlogaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UlogaService {

    private final UlogaRepository ulogaRepository;

    public UlogaService(UlogaRepository ulogaRepository) {
        this.ulogaRepository = ulogaRepository;
    }

    public List<UlogaDto> getAll() {
        List<Uloga> minHardvers = ulogaRepository.findAll();
        return minHardvers.stream().map(UlogaDto::new).collect(Collectors.toList());
    }

    public Optional<Uloga> getUlogaById(Long id) {
        return ulogaRepository.findById(id);
    }
}
