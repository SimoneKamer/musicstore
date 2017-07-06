package com.github.shmvanhouten.musicstore.Album;

import com.github.shmvanhouten.musicstore.Artist.Artist;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.AlbumColumns.ALBUM_ARTIST_ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.AlbumColumns.ALBUM_ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.AlbumColumns.ALBUM_TITLE;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.ALBUM;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Table.ARTIST;
import static com.github.shmvanhouten.musicstore.util.NamedParamUtil.namedParam;

@Repository
public class AlbumRepositoryJdbcTemplateImpl implements AlbumRepository{
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AlbumRepositoryJdbcTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Album> getAllAlbumsForArtist(Artist artist) {
        return Collections.emptyList();
    }

    @Override
    public Long getIdByTitleAndArtist(String title, String artistName) {
        String selectQuery =  new SQL()
                .SELECT(ALBUM_ID)
                .FROM(ALBUM)
                .JOIN(ARTIST + " ON " + ALBUM_ARTIST_ID + " = " + ARTIST_ID )
                .WHERE(ALBUM_TITLE + " = " + namedParam(ALBUM_TITLE))
                .WHERE(ARTIST_NAME + " = " + namedParam(ARTIST_NAME))
                .toString();
        SqlParameterSource params = new MapSqlParameterSource(ALBUM_TITLE, title)
                .addValue(ARTIST_NAME, artistName);
        return namedParameterJdbcTemplate.queryForObject(selectQuery, params, Long.class);
    }
}
