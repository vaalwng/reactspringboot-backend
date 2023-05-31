package com.zesty.reactspringbootbackend.model;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.zesty.reactspringbootbackend.TestUtils.AssertionsExtended.verifyToString;
import static com.zesty.reactspringbootbackend.TestUtils.AssertionsExtended.verifyEqualsAndHashCode;
import static com.zesty.reactspringbootbackend.TestUtils.AssertionsExtended.verifySerdes;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimeTest {

    protected static Anime createAnime() {
        return new Anime("Attack on Titan",
            24,
            2013,
            "IG Port's Wit Studio",
            false,
            9.5
        );
    }

    @Test @DisplayName("getter")
    void getter() {
        val anime = createAnime();
        assertEquals("Attack on Titan", anime.getTitle());
        assertEquals(24, anime.getEpisodeCount());
        assertEquals(2013, anime.getYearOfRelease());
        assertEquals("IG Port's Wit Studio", anime.getStudio());
        assertFalse(anime.isCurrentlyAiring());
        assertEquals(9.5, anime.getScore());
    }

    @Test @DisplayName("toString")
    void string() {
        verifyToString(
            "Anime(id=null, title=Attack on Titan, episodeCount=24, yearOfRelease=2013, studio=IG Port's Wit Studio, isCurrentlyAiring=false, score=9.5)",
            createAnime()
        );
    }

    @Test @DisplayName("equals and hash")
    void equalsAndHash() {
        verifyEqualsAndHashCode(createAnime(), createAnime());
    }

    @Test @DisplayName("serdes")
    void serdes() throws IOException {
        verifySerdes(
            createAnime(),
            "{\"id\":null,\"title\":\"Attack on Titan\",\"studio\":\"IG Port's Wit Studio\",\"score\":9.5,\"episodeCount\":24,\"yearOfRelease\":2013,\"isCurrentlyAiring\":false}"
        );
    }

}
