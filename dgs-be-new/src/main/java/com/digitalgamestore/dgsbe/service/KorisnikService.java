package com.digitalgamestore.dgsbe.service;

import com.digitalgamestore.dgsbe.dtos.KorisnikDto;
import com.digitalgamestore.dgsbe.model.Korisnik;
import com.digitalgamestore.dgsbe.repository.KorisnikRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    public List<KorisnikDto> getAll() {
        List<Korisnik> korisniks = korisnikRepository.findAll();
        return korisniks.stream().map(KorisnikDto::new).collect(Collectors.toList());
    }

    public Optional<Korisnik> getKorisnikById(Long id) {
        return korisnikRepository.findById(id);
    }
}
