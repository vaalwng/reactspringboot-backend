package com.zesty.reactspringbootbackend.services;

import com.zesty.reactspringbootbackend.db.AnimeRepository;
import com.zesty.reactspringbootbackend.model.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServices {

    @Autowired
    private AnimeRepository animeRepository;

    public Anime createAnime(Anime newAnime) {
        return animeRepository.save(newAnime);
    }

    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

}
