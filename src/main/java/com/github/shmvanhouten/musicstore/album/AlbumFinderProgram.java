package com.github.shmvanhouten.musicstore.album;

import com.github.shmvanhouten.musicstore.ArtistService;
import com.github.shmvanhouten.musicstore.FindAlbumsForArtistController;

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
