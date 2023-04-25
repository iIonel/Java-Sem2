package org.example;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args )
    {
        try {
            ArtistDAO artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");

            GenreDAO genres = new GenreDAO();
            genres.create("Rock");
            genres.create("Pop");
            genres.create("Funk");
            genres.create("Soul");
            Database.getConnection().commit();

            AlbumDAO albums = new AlbumDAO();
            ((AlbumDAO) albums).create(1979, "The Wall", "Pink Floyd", "Rock");
            albums.create(1982, "Thriller", "Michael Jackson", "Pop");
            albums.printAll();
            Database.getConnection().close();
        }
        catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}