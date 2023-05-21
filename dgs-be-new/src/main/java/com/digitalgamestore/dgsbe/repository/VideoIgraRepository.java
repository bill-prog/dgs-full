package com.digitalgamestore.dgsbe.repository;

import com.digitalgamestore.dgsbe.model.VideoIgra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoIgraRepository extends JpaRepository<VideoIgra, Integer> {

    List<VideoIgra> findByKategorija_Id(Integer kategorijaId);

    Optional<VideoIgra> findByNazivVideoigre(String value);


    List<VideoIgra> findByNazivVideoigreContainingIgnoreCase(String value);

}
