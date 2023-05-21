package com.digitalgamestore.dgsbe.repository;

import com.digitalgamestore.dgsbe.model.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {


    List<Kategorija> findByNazivKategorijeContainingIgnoreCase(String value);

    Optional<Kategorija> findByNazivKategorije(String value);

}
