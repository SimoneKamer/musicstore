package com.github.shmvanhouten.musicstore.Artist;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.ARTIST;
import static com.github.shmvanhouten.musicstore.util.NamedParamUtil.namedParam;

@Repository
public class ArtistRepositoryJdbcTemplateImpl implements ArtistRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ArtistRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<Artist> getAll() {
        String selectQuery = new SQL().SELECT(ARTIST_ID)
                .SELECT(ARTIST_NAME)
                .FROM(ARTIST)
                .toString();
        return jdbcTemplate.query(selectQuery, new ArtistRowMapper());
    }

    @Override
    public Long addArtist(String name) {
        Long nextId = getNextArtistId();
        String insertSql = new SQL()
                .INSERT_INTO(ARTIST)
                .VALUES(ARTIST_ID, namedParam(ARTIST_ID))
                .VALUES(ARTIST_NAME, namedParam(ARTIST_NAME))
                .toString();
        SqlParameterSource params = new MapSqlParameterSource(ARTIST_ID, nextId)
                .addValue(ARTIST_NAME, name);
        namedParameterJdbcTemplate.update(insertSql, params);
        return nextId;
    }

    @Override
    public Artist getById(Long id) {
        String selectQuery = new SQL()
                .SELECT(ARTIST_ID)
                .SELECT(ARTIST_NAME)
                .FROM(ARTIST)
                .WHERE(ARTIST_ID + " = " + namedParam(ARTIST_ID))
                .toString();
        SqlParameterSource params = new MapSqlParameterSource(ARTIST_ID, id);
        return namedParameterJdbcTemplate.queryForObject(selectQuery, params, new ArtistRowMapper());
    }

    private Long getNextArtistId() {
        String selectQuery = new SQL()
                .SELECT("MAX(" + ARTIST_ID + ")")
                .FROM(ARTIST)
                .toString();
        return jdbcTemplate.queryForObject(selectQuery, Long.class) + 1;
    }
}
