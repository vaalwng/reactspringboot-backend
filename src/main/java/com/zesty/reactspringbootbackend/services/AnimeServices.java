package com.zesty.reactspringbootbackend.services;

import com.zesty.reactspringbootbackend.db.AnimeRepository;
import com.zesty.reactspringbootbackend.exception.AnimeNotFoundException;
import com.zesty.reactspringbootbackend.model.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServices {

    @Autowired
    private AnimeRepository animeRepository;

    /**
     * Creates a new anime entry.
     * based on the anime object provided.
     * @param newAnime new Anime object to be persisted.
     * @return Anime entry persisted in the database
     */
    public Anime createAnime(Anime newAnime) {
        return animeRepository.save(newAnime);
    }

    /**
     * Gets a list of all the anime entries.
     * @return List of all animes entries in the database
     */
    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    /**
     * Retrieves the anime entry associated with the given id.
     * @param id id of Anime object to be searched
     * @return Anime object associated with given id
     * @throws AnimeNotFoundException anime entry not found exception
     */
    public Anime getAnimeById(Long id) {
        return animeRepository.findById(id)
            .orElseThrow(() -> new AnimeNotFoundException(id));
    }

    /**
     * Updates the existing anime entry associated the given id
     * with new anime entry information.
     * @param newAnime new anime entry with updated information
     * @param id id of existing anime entry
     * @return Anime entry updated in the database
     * @throws AnimeNotFoundException anime entry not found exception
     */
    public Anime updateAnime(Anime newAnime, Long id) {
        return animeRepository.findById(id)
            .map(anime -> {
                anime.setTitle(newAnime.getTitle());
                anime.setEpisodeCount(newAnime.getEpisodeCount());
                anime.setReleaseYear(newAnime.getReleaseYear());
                anime.setStudio(newAnime.getStudio());
                anime.setSimulcast(newAnime.isSimulcast());
                anime.setScore(newAnime.getScore());
                return animeRepository.save(anime);
            }).orElseThrow(() -> new AnimeNotFoundException(id));
    }

    /**
     * Deletes the anime entry associated with the given id.
     * @param id id of existing anime entry
     * @return String message of deletion status
     * @throws AnimeNotFoundException anime entry not found exception
     */
    public String deleteAnime(Long id) {
        if(!animeRepository.existsById(id)) {
            throw new AnimeNotFoundException(id);
        }
        animeRepository.deleteById(id);
        return String.format("Anime with id %s was deleted", id);
    }

}
