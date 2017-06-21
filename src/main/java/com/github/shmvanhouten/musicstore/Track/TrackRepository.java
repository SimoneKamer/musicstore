package com.github.shmvanhouten.musicstore.Track;

import com.github.shmvanhouten.musicstore.DatabaseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.shmvanhouten.musicstore.DatabaseStructure.Album.*;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Artist.*;
import static com.github.shmvanhouten.musicstore.DatabaseStructure.Track.*;

@Repository
public class TrackRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TrackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Track> getTracksForArtist(String name){
        String sql = "SELECT " + TRACK_TRACK_ID + ", " + TRACK_NAME + ", " + ALBUM_TITLE +
                " FROM "+ TRACK +
                " JOIN " + ALBUM + " ON " + ALBUM_ALBUM_ID + " = " + TRACK_ALBUM_ID +
                " JOIN " + ARTIST + " ON " + ARTIST_ARTIST_ID + " = " + ALBUM_ARTIST_ID +
                " WHERE " + ARTIST_NAME + " = ? ";
        String[] args = {name};
        return jdbcTemplate.query(sql, args, new TrackRowMapper());
    }
}
