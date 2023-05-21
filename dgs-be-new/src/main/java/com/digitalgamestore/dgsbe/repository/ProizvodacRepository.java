package com.digitalgamestore.dgsbe.repository;

import com.digitalgamestore.dgsbe.model.Proizvodac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProizvodacRepository extends JpaRepository<Proizvodac, Long> {

    List<Proizvodac> findByNazivProizvodacContainingIgnoreCase(String value);

    Optional<Proizvodac> findByNazivProizvodac(String value);


}
