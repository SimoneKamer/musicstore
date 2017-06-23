package com.github.shmvanhouten.musicstore.genre;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/genre")
public class GenreResource {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreResource(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @RequestMapping(method = GET)
    @ApiOperation(value = "getGenres", nickname = "getGenres")
    public List<Genre> getAll() {
        return genreRepository.getAll();

    }

    @RequestMapping(method = GET, path = "/{id}")
    public Genre getById(@PathVariable("id") Long id) {
        return genreRepository.getById(id);
    }

    @RequestMapping(method = POST)
    public Long addGenre(String name) {
        return genreRepository.addGenre(name);
    }



}
