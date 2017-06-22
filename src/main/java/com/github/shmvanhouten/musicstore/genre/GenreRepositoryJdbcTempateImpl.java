package com.github.shmvanhouten.musicstore.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository
public class GenreRepositoryJdbcTempateImpl implements GenreRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreRepositoryJdbcTempateImpl(DataSource dataSource) {
        System.out.println("Got a DataSource");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }




    @Override
    public List<Genre> getAll() {
        return Collections.emptyList();
    }
}
