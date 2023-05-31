package com.zesty.reactspringbootbackend.exception;

public class AnimeNotFoundException extends RuntimeException{

    public AnimeNotFoundException(Long id) {
        super(String.format("Could not find anime with id %s", id));
    }

}
