package com.github.shmvanhouten.musicstore.Artist;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.github.shmvanhouten.musicstore.Artist.Artist.ArtistBuilder.anArtist;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_NAME;

public class ArtistRowMapper implements RowMapper<Artist> {
    @Override
    public Artist mapRow(ResultSet resultSet, int i) throws SQLException {
        return anArtist()
                .withArtistId(resultSet.getInt(ARTIST_ID))
                .withName(resultSet.getString(ARTIST_NAME))
                .build();
    }
}
