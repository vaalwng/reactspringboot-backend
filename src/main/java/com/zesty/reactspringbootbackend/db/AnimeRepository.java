package com.zesty.reactspringbootbackend.db;

import com.zesty.reactspringbootbackend.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
