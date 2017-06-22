package com.github.shmvanhouten.musicstore.genre;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.GenreColumns.ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.GenreColumns.NAME;
import static com.github.shmvanhouten.musicstore.genre.Genre.GenreBuilder.aGenre;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        return aGenre()
                .withId(resultSet.getLong(ID))
                .withName(resultSet.getString(NAME))
                .build();
    }
}
