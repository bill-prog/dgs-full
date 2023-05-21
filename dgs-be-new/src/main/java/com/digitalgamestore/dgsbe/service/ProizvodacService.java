package com.digitalgamestore.dgsbe.service;

import com.digitalgamestore.dgsbe.dtos.ProizvodacDto;
import com.digitalgamestore.dgsbe.exception.ResponseException;
import com.digitalgamestore.dgsbe.model.Proizvodac;
import com.digitalgamestore.dgsbe.repository.ProizvodacRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProizvodacService {

    private final ProizvodacRepository proizvodacRepository;

    public ProizvodacService(ProizvodacRepository proizvodacRepository) {
        this.proizvodacRepository = proizvodacRepository;
    }

    public List<ProizvodacDto> getAll() {
        List<Proizvodac> minHardvers = proizvodacRepository.findAll();
        return minHardvers.stream().map(ProizvodacDto::new).collect(Collectors.toList());
    }

    public List<ProizvodacDto> getByText(String text) {
        List<Proizvodac> kategorijas = proizvodacRepository.findByNazivProizvodacContainingIgnoreCase(text);
        return kategorijas.stream().map(ProizvodacDto::new).collect(Collectors.toList());
    }

    public ProizvodacDto save(ProizvodacDto proizvodacDto) {

        String exists = exists(proizvodacDto);
        if (exists != null) {
            throw new ResponseException("Proizvodac with that name already exists.");
        }

        Proizvodac proizvodac = new Proizvodac();
        proizvodac.setNazivProizvodac(proizvodacDto.getNazivProizvodac());
        proizvodac.setGodOsnutka(proizvodacDto.getGodOsnutka());

        // Save the entity to the database
        return new ProizvodacDto(proizvodacRepository.save(proizvodac));
    }

    public void delete(Long id) {
        proizvodacRepository.deleteById(id);
    }

    public Optional<Proizvodac> getProizvodacById(Long id) {
        return proizvodacRepository.findById(id);
    }

    public ProizvodacDto update(Long id, ProizvodacDto proizvodacDto) {

        String exists = exists(proizvodacDto);
        Optional<Proizvodac> optionalProizvodac = proizvodacRepository.findById(id);

        if (optionalProizvodac.isPresent()) {

            if (exists != null) {
                if (!optionalProizvodac.get().getNazivProizvodac().equals(exists)) {
                    throw new ResponseException("Proizvodac with that name already exists.");
                }
            }
            Proizvodac proizvodac = optionalProizvodac.get();

            // Update the Proizvodac entity with new values from the DTO
            proizvodac.setNazivProizvodac(proizvodacDto.getNazivProizvodac());


            Date godosnutka = proizvodacDto.getGodOsnutka();
            proizvodac.setGodOsnutka(godosnutka);


            // Save the updated entity back to the database
            return new ProizvodacDto(proizvodacRepository.save(proizvodac));
        } else {
            throw new ResponseException("Proizvodac not found");
        }
    }

    private String exists(ProizvodacDto dto) {
        Optional<Proizvodac> exists = proizvodacRepository.
                findByNazivProizvodac(dto.getNazivProizvodac());

        if (exists.isPresent()) {
            return exists.get().getNazivProizvodac();
        }
        return null;
    }
}
