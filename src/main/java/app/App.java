package app;

import app.entities.Artist;
import app.entities.Genre;
import app.service.GenreService;
import org.springframework.data.domain.Page;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import app.service.ArtistService;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);

        //ArtistService artistService = ctx.getBean(ArtistService.class);
        //List<Artist> list = artistService.getAllArtists();

        //All artists with name: Symphony
        //List<Artist> list = artistService.getArtistByName("Symphony");

        //Artists with id greater than 270
        //List<Artist> list = artistService.getArtistWithIdGreaterThan(270);

        //for (Artist ar : list) {
        //    System.out.println(String.format("ID: %d, name: %s", ar.getArtistId(), ar.getName()));
        //}

        //Page 1 of artists with name: Symphony
        //Pageable pageable = PageRequest.of(1, 5);
        //Page<Artist> page = artistService.getByNameContainingIgnoreCase("Symphony", pageable);

        //Page<Artist> page = artistService.getByNameContainingIgnoreCase("Symphony", PageRequest.of(1, 5));

        //for (Artist ar : page.getContent()) {
        //    System.out.println(String.format("ID: %d, name: %s", ar.getArtistId(), ar.getName()));
        //}

        //Nghệ sĩ có ID = 270
        //Artist artist = artistService.getByArtistId1(270);
        //System.out.println(String.format("ID: %d, Name: %s", artist.getArtistId(), artist.getName()));

        //--------------------------------------------------------------------------------------------
        //Genre
        GenreService genreService = ctx.getBean(GenreService.class);
        //List<Genre> list =  genreService.getAllGenres();
        //for (Genre genre : list) {
        //    System.out.println(String.format("ID: %d, name: %s", genre.getGenreId(), genre.getName()));
        //}

        //Genre genre = genreService.getByGenreId(1);
        //System.out.println(String.format("ID: %d, name: %s", genre.getGenreId(), genre.getName()));

        //Page<Genre> page = genreService.getByNameContainingIgnoreCase("Rock", PageRequest.of(1, 1));

        //for (Genre genre : page.getContent()) {
        //    System.out.println(String.format("ID: %d, name: %s", genre.getGenreId(), genre.getName()));
        //}

        //List<Genre> genres = genreService.getGenresWithShortName();
        //for (Genre genre : genres) {
        //    System.out.println(String.format("ID: %d, name: %s", genre.getGenreId(), genre.getName()));
        //}

    }
}
