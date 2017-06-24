package com.github.shmvanhouten.musicstore.Track;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.AlbumColumns.*;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.*;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.*;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.TrackColumns.*;
import static com.github.shmvanhouten.musicstore.util.NamedParamUtil.namedParam;

@Repository
public class TrackRepositoryJdbcTemplateImpl implements TrackRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TrackRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Track> getTracksForArtist(String name){
        String sql = new SQL().SELECT(TRACK_ID)
                .SELECT(TRACK_NAME)
                .SELECT(ALBUM_TITLE)
                .SELECT(ARTIST_NAME)
                .FROM(TRACK)
                .JOIN(ALBUM + " ON " + ALBUM_ID + " = " + TRACK_ALBUM_ID)
                .JOIN(ARTIST + " ON " + ARTIST_ID + " = " + ALBUM_ARTIST_ID)
                .WHERE(ARTIST_NAME + " = " + namedParam(ARTIST_NAME))
                .toString();
        SqlParameterSource params = new MapSqlParameterSource(ARTIST_NAME, name);
        return namedParameterJdbcTemplate.query(sql, params, new TrackRowMapper());
    }

    @Override
    public List<Track> getTracksForAlbum(String artistName, String albumName) {
        String sql = new SQL().SELECT(TRACK_ID)
                .SELECT(TRACK_NAME)
                .SELECT(ALBUM_TITLE)
                .SELECT(ARTIST_NAME)
                .FROM(TRACK)
                .JOIN(ALBUM + " ON " + ALBUM_ID + " = " + TRACK_ALBUM_ID)
                .JOIN(ARTIST + " ON " + ARTIST_ID + " = " + ALBUM_ARTIST_ID)
                .WHERE(ARTIST_NAME + " = " + namedParam(ARTIST_NAME))
                .WHERE(ALBUM_TITLE + " = " + namedParam(ALBUM_TITLE))
                .toString();
        SqlParameterSource params = new MapSqlParameterSource(ARTIST_NAME, artistName)
                .addValue(ALBUM_TITLE, albumName);
        return namedParameterJdbcTemplate.query(sql, params, new TrackRowMapper());
    }

    @Override
    public Long setTrack(TrackRequest trackRequest) {
        Long nextId = getNextTrackId();
        //todo: make a TrackService
        // Long albumId = albumRepository.getIdByNameAndArtist
        String insertSql = new SQL()
                .INSERT_INTO(TRACK)
                .VALUES(TRACK_ID, namedParam(TRACK_ID))
                .VALUES(TRACK_NAME, namedParam(TRACK_NAME))
                .VALUES(TRACK_ALBUM_ID, namedParam(ALBUM_ID))
                .toString();
        return nextId;
    }

    @Override
    public Long getNextTrackId() {
        String selectQuery = new SQL()
                .SELECT("MAX(" + TRACK_ID + ")")
                .FROM(TRACK)
                .toString();
        return jdbcTemplate.queryForObject(selectQuery, Long.class) + 1;
    }
}
