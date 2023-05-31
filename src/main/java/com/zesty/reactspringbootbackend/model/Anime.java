package com.zesty.reactspringbootbackend.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class Anime {

    @Id @GeneratedValue
    private Long id;
    private String title;
    @JsonProperty("episodeCount") private Integer episodeCount;
    @JsonProperty("releaseYear") private int releaseYear;
    private String studio;
    @JsonProperty("isSimulcast") private boolean isSimulcast;
    private Double score;

    public Anime() {
    }

    public Anime(String title,
                 Integer episodeCount,
                 int releaseYear,
                 String studio,
                 boolean isSimulcast,
                 Double score) {
        this.title = title;
        this.episodeCount = episodeCount;
        this.releaseYear = releaseYear;
        this.studio = studio;
        this.isSimulcast = isSimulcast;
        this.score = score;
    }

}
