package com.github.shmvanhouten.musicstore.Artist;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.ARTIST;

@Repository
public class ArtistRepositoryJdbcTemplateImpl implements ArtistRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArtistRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Artist> getAll() {
        String selectQuery = new SQL().SELECT(ARTIST_ID)
                .SELECT(ARTIST_NAME)
                .FROM(ARTIST)
                .toString();
        return jdbcTemplate.query(selectQuery, new ArtistRowMapper());
    }
}
