package com.github.shmvanhouten.musicstore.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github.shmvanhouten.musicstore.genre.Genre.GenreBuilder.aGenre;
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

    @RequestMapping(method = GET, path = "/{id}")
    public Genre getById(@PathVariable("id") Long id) {
        return aGenre().withId(id).withName("Hardcoded").build();
    }

}
