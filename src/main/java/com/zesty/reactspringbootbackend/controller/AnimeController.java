package com.zesty.reactspringbootbackend.controller;

import com.zesty.reactspringbootbackend.model.Anime;
import com.zesty.reactspringbootbackend.services.AnimeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @Slf4j
@RequestMapping(path="api/anime")
public class AnimeController {

    @Autowired
    private AnimeServices animeServices;

    @PostMapping("/createAnime")
    Anime createAnimeEntry(@RequestBody Anime newAnime) {
       return animeServices.createAnime(newAnime);
    }

    @GetMapping("/users")
    List<Anime> getAllAnimeEntries() {
        return animeServices.getAllAnime();
    }

}
