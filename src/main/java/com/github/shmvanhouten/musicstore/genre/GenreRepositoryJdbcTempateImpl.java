package com.github.shmvanhouten.musicstore.genre;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.GenreColumns.ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.GenreColumns.NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.GENRE;

@Repository
public class GenreRepositoryJdbcTempateImpl implements GenreRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreRepositoryJdbcTempateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
                .WHERE(ID + " = ?")
                .toString();


        Object[] params = {id};
        return jdbcTemplate.queryForObject(selectQuery, params, new GenreRowMapper());
    }


}
