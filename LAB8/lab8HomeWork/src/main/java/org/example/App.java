package org.example;
import java.util.List;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws IOException, SQLException {
        String fileName = "C:\\Users\\maste\\Documents\\JavaLabs\\LAB8\\lab8HomeWork\\src\\main\\java\\albumlist.csv";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        ArtistDAO artists = new ArtistDAO();
        GenreDAO genres = new GenreDAO();
        AlbumDAO albums = new AlbumDAO() {
            @Override
            public void create(String artist) throws SQLException {

            }

            @Override
            public String findById(int id) throws SQLException {
                return null;
            }

            @Override
            public List<Album> findAll() throws SQLException {
                return null;
            }

            @Override
            public Integer findByName(String name) {
                return 0;
            }
        };
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            String id = tokens[0].trim();
            String year = tokens[1].trim();
            String album = tokens[2].trim();
            album = album.replaceAll("'","");
            String artist = tokens[3].trim();
            artist = artist.replaceAll("'","");
            String genre = tokens[4].trim();
            genre = genre.replaceAll("'","");

            try {
                artists.create(artist);
                genres.create(genre);
                Database.getConnection().commit();
                ((AlbumDAO) albums).create(Integer.valueOf(year), album, artist, genre);
            }
            catch (SQLException e) {
                System.err.println(e);
                Database.rollback();
            }
        }
        reader.close();
        albums.printAll();
        Database.getConnection().close();
    }
}