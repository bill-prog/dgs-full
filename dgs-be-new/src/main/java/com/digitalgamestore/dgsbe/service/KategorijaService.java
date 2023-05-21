package com.digitalgamestore.dgsbe.service;

import com.digitalgamestore.dgsbe.dtos.KategorijaDto;
import com.digitalgamestore.dgsbe.exception.ResponseException;
import com.digitalgamestore.dgsbe.model.Kategorija;
import com.digitalgamestore.dgsbe.model.Korisnik;
import com.digitalgamestore.dgsbe.repository.KategorijaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KategorijaService {


    private final KorisnikService korisnikService;

    private final KategorijaRepository kategorijaRepository;

    public KategorijaService(KategorijaRepository kategorijaRepository,
                             KorisnikService korisnikService) {
        this.kategorijaRepository = kategorijaRepository;
        this.korisnikService = korisnikService;
    }


    public List<KategorijaDto> getAll() {
        List<Kategorija> kategorijas = kategorijaRepository.findAll();
        return kategorijas.stream().map(KategorijaDto::new).collect(Collectors.toList());
    }

    public List<KategorijaDto> getByText(String text) {
        List<Kategorija> kategorijas = kategorijaRepository.findByNazivKategorijeContainingIgnoreCase(text);
        return kategorijas.stream().map(KategorijaDto::new).collect(Collectors.toList());
    }

    public KategorijaDto save(KategorijaDto kategorijaDto) {

        String exists = exists(kategorijaDto);
        if (exists != null) {
            throw new ResponseException("Kategorija with that name already exists.");
        }

        Kategorija kategorija = new Kategorija();
        kategorija.setOpisKategorije(kategorijaDto.getOpisKategorije());
        kategorija.setNazivKategorije(kategorijaDto.getNazivKategorije());

        Optional<Korisnik> admin = korisnikService.getKorisnikById(
                Long.valueOf(kategorijaDto.getIdAdmin()));

        if (admin.isPresent()) {
            kategorija.setAdmin(admin.get());
        } else {
            // handle the case where the admin is not found
            throw new ResponseException("Admin not found with id " + kategorijaDto.getIdAdmin());
        }

        return new KategorijaDto(kategorijaRepository.save(kategorija));
    }

    public void delete(Long id) {
        kategorijaRepository.deleteById(id);
    }

    public Optional<Kategorija> getKategorijaById(Long id) {
        return kategorijaRepository.findById(id);
    }

    public KategorijaDto update(Long id, KategorijaDto kategorijaDto) {

        String exists = exists(kategorijaDto);



        Optional<Kategorija> optionalKategorija = kategorijaRepository.findById(id);

        if (optionalKategorija.isPresent()) {
            if (exists != null) {
                if (!optionalKategorija.get().getNazivKategorije().equals(exists)) {
                    throw new ResponseException("Kategorija with that name already exists.");
                }
            }
            Kategorija kategorija = optionalKategorija.get();

            kategorija.setOpisKategorije(kategorijaDto.getOpisKategorije());
            kategorija.setNazivKategorije(kategorijaDto.getNazivKategorije());

            Optional<Korisnik> optionalKorisnik = korisnikService.getKorisnikById(Long.valueOf(kategorijaDto.getIdAdmin()));
            if (optionalKorisnik.isPresent()) {
                Korisnik admin = optionalKorisnik.get();
                kategorija.setAdmin(admin);
            } else {
                throw new ResponseException("Admin not found");
            }

            return new KategorijaDto(kategorijaRepository.save(kategorija));
        } else {
            throw new ResponseException("Kategorija not found");
        }
    }

    private String exists(KategorijaDto dto) {
        Optional<Kategorija> exists = kategorijaRepository.
                findByNazivKategorije(dto.getNazivKategorije());

        if (exists.isPresent()) {
            return dto.getNazivKategorije();
        }
        return null;
    }
}


