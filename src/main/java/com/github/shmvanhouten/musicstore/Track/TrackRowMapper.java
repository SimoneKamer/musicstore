package com.github.shmvanhouten.musicstore.Track;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.AlbumColumns.ALBUM_TITLE;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.ArtistColumns.ARTIST_NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.TrackColumns.TRACK_NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.TrackColumns.TRACK_ID;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.TrackColumns.UNIT_PRICE;
import static com.github.shmvanhouten.musicstore.Track.Track.TrackBuilder.aTrack;

public class TrackRowMapper implements RowMapper<Track> {

    @Override
    public Track mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return aTrack()
                .withTrackId(resultSet.getInt(TRACK_ID))
                .withName(resultSet.getString(TRACK_NAME))
                .withAlbumTitle(resultSet.getString(ALBUM_TITLE))
                .withArtistName(resultSet.getString(ARTIST_NAME))
                .withPrice(resultSet.getBigDecimal(UNIT_PRICE))
                .build();
    }
}
