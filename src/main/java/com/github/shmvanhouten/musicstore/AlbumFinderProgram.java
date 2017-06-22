package com.github.shmvanhouten.musicstore;

import com.github.shmvanhouten.musicstore.Album.Album;
import com.github.shmvanhouten.musicstore.Album.AlbumRepository;
import com.github.shmvanhouten.musicstore.Album.AlbumService;
import com.github.shmvanhouten.musicstore.Album.FindAlbumsForArtistController;
import com.github.shmvanhouten.musicstore.Artist.ArtistService;

import java.util.List;

public class AlbumFinderProgram {

    public static void main(String[] args) {

        AlbumRepository albumRepository = new AlbumRepository();
        AlbumService albumService = new AlbumService(albumRepository);
        ArtistService artistService = new ArtistService();
        FindAlbumsForArtistController controller = new FindAlbumsForArtistController(artistService, albumService);


        List<Album> albumsForArtist = controller.getAlbumsForArtist("John Doe");

        for (Album album : albumsForArtist) {
            System.out.println(album.getTitle());
        }

    }
}
