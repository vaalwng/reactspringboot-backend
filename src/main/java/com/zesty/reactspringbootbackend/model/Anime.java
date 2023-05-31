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
    @JsonProperty("episodeCount")
    private Integer episodeCount;
    @JsonProperty("yearOfRelease")
    private int yearOfRelease;
    private String studio;
    @JsonProperty("isCurrentlyAiring")
    private boolean isCurrentlyAiring;
    private Double score;

    public Anime() {
    }

    public Anime(String title,
                 Integer episodeCount,
                 int yearOfRelease,
                 String studio,
                 boolean isCurrentlyAiring,
                 Double score) {
        this.title = title;
        this.episodeCount = episodeCount;
        this.yearOfRelease = yearOfRelease;
        this.studio = studio;
        this.isCurrentlyAiring = isCurrentlyAiring;
        this.score = score;
    }

}
