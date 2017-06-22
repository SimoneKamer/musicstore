package com.github.shmvanhouten.musicstore.genre;

import java.util.List;

public interface GenreRepository {

    List<Genre> getAll();

    Genre getById(Long id);
}
