package com.zesty.reactspringbootbackend.controller;

import com.zesty.reactspringbootbackend.model.Anime;
import com.zesty.reactspringbootbackend.services.AnimeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @Slf4j
@RequestMapping(path="api/anime") @CrossOrigin("http://localhost:3000")
public class AnimeController {

    @Autowired
    private AnimeServices animeServices;

    @PostMapping("/create")
    Anime createAnimeEntry(@RequestBody Anime newAnime) {
       return animeServices.createAnime(newAnime);
    }

    @GetMapping("/catalog")
    List<Anime> catalog() {
        return animeServices.getAllAnime();
    }

    @GetMapping("/{id}")
    Anime getAnimeEntry(@PathVariable Long id) {
        return animeServices.getAnimeById(id);
    }

    @PutMapping("/{id}")
    Anime updateAnimeEntry(@RequestBody Anime newAnime, @PathVariable Long id) {
        return animeServices.updateAnime(newAnime, id);
    }

    @DeleteMapping("/{id}")
    String deleteAnimeEntry(@PathVariable Long id) {
        return animeServices.deleteAnime(id);
    }

}
