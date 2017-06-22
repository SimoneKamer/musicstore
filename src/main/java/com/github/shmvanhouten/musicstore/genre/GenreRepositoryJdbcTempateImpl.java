package com.github.shmvanhouten.musicstore.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.GENRE;

@Repository
public class GenreRepositoryJdbcTempateImpl implements GenreRepository {


    private final JdbcTemplate jdbcTemplate;



    @Autowired
    public GenreRepositoryJdbcTempateImpl(JdbcTemplate jdbcTemplate) {
        System.out.println("Got a JdbcTemplate");
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Genre> getAll() {
        String selectQuery = "SELECT * FROM " + GENRE;
        return jdbcTemplate.query(selectQuery, new GenreRowMapper());
    }
}
