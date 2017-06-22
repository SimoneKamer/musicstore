package com.github.shmvanhouten.musicstore.genre;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github.shmvanhouten.musicstore.genre.Genre.GenreBuilder.aGenre;
import static java.util.Arrays.asList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/genre")
public class GenreResource {

    @RequestMapping(method = GET)
    public List<Genre> getAll() {
        return asList(aGenre().withId(545L).withName("Demo").build());

    }

}
