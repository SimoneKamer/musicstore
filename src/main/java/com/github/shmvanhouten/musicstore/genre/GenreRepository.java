package com.github.shmvanhouten.musicstore.genre;

import com.github.shmvanhouten.musicstore.genre.Genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> getAll();

}
