package com.digitalgamestore.dgsbe.controller;

import com.digitalgamestore.dgsbe.dtos.VideoIgraDto;
import com.digitalgamestore.dgsbe.model.VideoIgra;
import com.digitalgamestore.dgsbe.service.VideoIgraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videoigra")
public class VideoIgraController {

    private final VideoIgraService videoIgraService;


    public VideoIgraController(VideoIgraService videoIgraService) {
        this.videoIgraService = videoIgraService;
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<VideoIgraDto>> getVideoIgras()
    {
        List<VideoIgraDto> videoIgraDtos = videoIgraService.getAll();
        return ResponseEntity.ok(videoIgraDtos);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<VideoIgraDto> getVideoIgra(@PathVariable Integer id) {
        Optional<VideoIgra> videoIgra = videoIgraService.getVideoIgraById(id);
        return ResponseEntity.ok(new VideoIgraDto(videoIgra.get()));
    }

    @GetMapping(path = "/get/categoryid/{categoryId}")
    public ResponseEntity<List<VideoIgraDto>> getVideoIgraByCategoryId(@PathVariable Integer categoryId) {
        List<VideoIgraDto> videoIgra = videoIgraService.getByCategoryId(categoryId);
        return ResponseEntity.ok(videoIgra);

    }

    @GetMapping(path = "/search/{text}")
    public ResponseEntity<List<VideoIgraDto>> searchVideoIgra(@PathVariable String text) {
        List<VideoIgraDto> videoigras = videoIgraService.getByText(text);
        return ResponseEntity.ok(videoigras);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<VideoIgraDto> createVideoIgra(
            @RequestBody VideoIgraDto videoIgraDto
    ) {
        return ResponseEntity.ok(videoIgraService.save(videoIgraDto));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteVideoIgra(
            @PathVariable Integer id) {
        videoIgraService.delete(id);
        return ResponseEntity.ok("");
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<VideoIgraDto> updateVideoIgra(
            @PathVariable Integer id,
            @RequestBody VideoIgraDto videoIgraDto

    ) {
        return ResponseEntity.ok(videoIgraService.update(id, videoIgraDto));
    }
}
