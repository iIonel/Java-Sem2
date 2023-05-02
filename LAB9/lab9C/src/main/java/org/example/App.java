package org.example;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        AlbumRepository albumRepository = new AlbumRepository(emf);

        Album album = new Album();
        album.setName("Revolver");
        album.setYear(1966);
        album.setGenre("Rock");
        Artist artist = new Artist();
        artist.setName("The Beatles");
        album.setArtist(artist);
        albumRepository.create(album);

        Album foundAlbum = albumRepository.findById(2L);
        System.out.println(foundAlbum.getName() + " by " + foundAlbum.getArtist().getName());

        List<Album> albums = albumRepository.findByName("Rev");
        for (Album a : albums) {
            System.out.println(a.getName() + " by " + a.getArtist().getName());
        }
    }
}
