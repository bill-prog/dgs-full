package com.digitalgamestore.dgsbe.service;

import com.digitalgamestore.dgsbe.dtos.MinHardverDto;
import com.digitalgamestore.dgsbe.model.MinHardver;
import com.digitalgamestore.dgsbe.repository.MinHardverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MinHardverService {

    private final MinHardverRepository minHardverRepository;

    public MinHardverService(MinHardverRepository minHardverRepository) {
        this.minHardverRepository = minHardverRepository;
    }

    public List<MinHardverDto> getAll() {
        List<MinHardver> minHardvers = minHardverRepository.findAll();
        return minHardvers.stream().map(MinHardverDto::new).collect(Collectors.toList());
    }

    public Optional<MinHardver> getHardverById(Long id) {
        return minHardverRepository.findById(id);
    }

}
