package com.digitalgamestore.dgsbe.service;

import com.digitalgamestore.dgsbe.dtos.VideoIgraDto;
import com.digitalgamestore.dgsbe.exception.ResponseException;
import com.digitalgamestore.dgsbe.model.Kategorija;
import com.digitalgamestore.dgsbe.model.MinHardver;
import com.digitalgamestore.dgsbe.model.Proizvodac;
import com.digitalgamestore.dgsbe.model.VideoIgra;
import com.digitalgamestore.dgsbe.repository.VideoIgraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoIgraService {
    private final VideoIgraRepository videoIgraRepository;

    private final KategorijaService kategorijaService;
    private final MinHardverService minHardverService;

    private final ProizvodacService proizvodacService;


    public VideoIgraService(VideoIgraRepository videoIgraRepository,
                            KategorijaService kategorijaService,
                            MinHardverService minHardverService,
                            ProizvodacService proizvodacService) {
        this.videoIgraRepository = videoIgraRepository;
        this.kategorijaService = kategorijaService;
        this.minHardverService = minHardverService;
        this.proizvodacService = proizvodacService;
    }

    public List<VideoIgraDto> getAll() {
        List<VideoIgra> videoigras = videoIgraRepository.findAll();
        return videoigras.stream().map(VideoIgraDto::new).collect(Collectors.toList());
    }

    public List<VideoIgraDto> getByCategoryId(Integer id) {
        List<VideoIgra> videoigras = videoIgraRepository.findByKategorija_Id(id);
        return videoigras.stream().map(VideoIgraDto::new).collect(Collectors.toList());
    }

    public VideoIgraDto save(VideoIgraDto videoIgraDto) {

        String exists = exists(videoIgraDto);
        if (exists != null) {
            throw new ResponseException("VideoIgra with that name already exists.");
        }

        VideoIgra videoigra = new VideoIgra();
        videoigra.setNazivVideoigre(videoIgraDto.getNazivVideoigre());
        videoigra.setCijenaVideoigre(videoIgraDto.getCijenaVideoigre());

        Optional<Kategorija> kategorija = kategorijaService.getKategorijaById(Long.valueOf(videoIgraDto.getIdKategorija()));
        Optional<MinHardver> minHardver = minHardverService.getHardverById(Long.valueOf(videoIgraDto.getIdMinHardver()));
        Optional<Proizvodac> proizvodac = proizvodacService.getProizvodacById(Long.valueOf(videoIgraDto.getIdProizvodac()));

        if (kategorija.isPresent() && minHardver.isPresent() && proizvodac.isPresent()) {
            videoigra.setKategorija(kategorija.get());
            videoigra.setMinHardver(minHardver.get());
            videoigra.setProizvodac(proizvodac.get());
        } else {
            throw new ResponseException("Cannot find related entity");
        }

        return new VideoIgraDto(videoIgraRepository.save(videoigra));
    }

    public void delete(Integer id) {
        videoIgraRepository.deleteById(id);
    }

    public VideoIgraDto update(Integer id, VideoIgraDto videoIgraDto) {

        String exists = exists(videoIgraDto);

        Optional<VideoIgra> optionalVideoigra = videoIgraRepository.findById(id);

        if (optionalVideoigra.isPresent()) {
            if (exists != null) {
                if (!optionalVideoigra.get().getNazivVideoigre().equals(exists))
                    throw new ResponseException("VideoIgra with that name already exists.");
            }

            VideoIgra videoigra = optionalVideoigra.get();

            // Update the fields of the entity from the DTO
            videoigra.setNazivVideoigre(videoIgraDto.getNazivVideoigre());
            videoigra.setCijenaVideoigre(videoIgraDto.getCijenaVideoigre());

            // Find the related entities based on the IDs in the DTO and set them in the Videoigra entity
            Optional<Kategorija> kategorija = kategorijaService.getKategorijaById(Long.valueOf(videoIgraDto.getIdKategorija()));
            Optional<MinHardver> minHardver = minHardverService.getHardverById(Long.valueOf(videoIgraDto.getIdMinHardver()));
            Optional<Proizvodac> proizvodac = proizvodacService.getProizvodacById(Long.valueOf(videoIgraDto.getIdProizvodac()));

            if (kategorija.isPresent() && minHardver.isPresent() && proizvodac.isPresent()) {
                videoigra.setKategorija(kategorija.get());
                videoigra.setMinHardver(minHardver.get());
                videoigra.setProizvodac(proizvodac.get());
            } else {
                throw new ResponseException("Cannot find related entity");
            }

            // Save the updated entity back to the database
            return new VideoIgraDto(videoIgraRepository.save(videoigra));
        } else {
            throw new ResponseException("Videoigra not found");
        }

    }

    public Optional<VideoIgra> getVideoIgraById(Integer id) {
        return videoIgraRepository.findById(id);
    }

    public List<VideoIgraDto> getByText(String text) {
        List<VideoIgra> videoigras = videoIgraRepository.findByNazivVideoigreContainingIgnoreCase(text);
        return videoigras.stream().map(VideoIgraDto::new).collect(Collectors.toList());

    }

    private String exists(VideoIgraDto dto) {
        Optional<VideoIgra> exists = videoIgraRepository.
                findByNazivVideoigre(dto.getNazivVideoigre());

        if (exists.isPresent()) {
            return exists.get().getNazivVideoigre();
        }
        return null;
    }
}
