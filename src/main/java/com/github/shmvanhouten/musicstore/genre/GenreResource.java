package com.github.shmvanhouten.musicstore.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/genre")
public class GenreResource {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreResource(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @RequestMapping(method = GET)
    public List<Genre> getAll() {
        return genreRepository.getAll();

    }

}
