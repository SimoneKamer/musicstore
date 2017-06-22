package com.github.shmvanhouten.musicstore.genre;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.GenreColumns.ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.GenreColumns.NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.GENRE;
import static com.github.shmvanhouten.musicstore.util.NamedParamUtil.namedParam;

@Repository
public class GenreRepositoryJdbcTempateImpl implements GenreRepository {


    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public GenreRepositoryJdbcTempateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }


    @Override
    public List<Genre> getAll() {
        String selectQuery = new SQL()
                .SELECT(ID)
                .SELECT(NAME)
                .FROM(GENRE)
                .toString();
        return jdbcTemplate.query(selectQuery, new GenreRowMapper());
    }

    @Override
    public Genre getById(Long id) {
        String selectQuery = new SQL()
                .SELECT(ID)
                .SELECT(NAME)
                .FROM(GENRE)
                .WHERE(ID + " = " + namedParam(ID))
                .toString();


        SqlParameterSource params = new MapSqlParameterSource(ID, id);

        return namedParameterJdbcTemplate.queryForObject(selectQuery, params, new GenreRowMapper());
    }

    @Override
    public Long addGenre(String name) {
        String query = new SQL()
                .SELECT("MAX(" + ID + ")")
                .FROM(GENRE)
                .toString();
        Long nextId = jdbcTemplate.queryForObject(query, Long.class) + 1;

        String insertSql = new SQL()
                .INSERT_INTO(GENRE)
                .VALUES(ID, namedParam(ID))
                .VALUES(NAME, namedParam(NAME))
                .toString();

        MapSqlParameterSource paramSource = new MapSqlParameterSource(ID, nextId).
                addValue(NAME, name);
        namedParameterJdbcTemplate.update(insertSql, paramSource);

        return nextId;
    }


}
