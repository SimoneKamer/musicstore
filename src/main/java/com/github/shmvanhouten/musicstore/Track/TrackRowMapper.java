package com.github.shmvanhouten.musicstore.Track;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.Album.ALBUM_TITLE;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Track.TRACK_NAME;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Track.TRACK_TRACK_ID;

public class TrackRowMapper implements RowMapper<Track> {

    @Override
    public Track mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int trackId = resultSet.getInt(TRACK_TRACK_ID);
        String name = resultSet.getString(TRACK_NAME);
        String albumTitle = resultSet.getString(ALBUM_TITLE);
        return new Track(trackId, name, albumTitle);
    }
}
