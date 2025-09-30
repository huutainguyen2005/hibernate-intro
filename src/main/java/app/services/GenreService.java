package app.service;

import app.entities.Artist;
import app.entities.Genre;
import app.repositories.GenreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    //DI
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    //List
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    //Get By ID
    public Genre getByGenreId(int id) {
        return genreRepository.getByGenreId(id);
    }

    //Phân trang
    public Page<Genre> getByNameContainingIgnoreCase(String name, Pageable pageable) {
        return genreRepository.getByNameContainingIgnoreCase(name, pageable);
    }

    //Lấy danh sách các Genre có tên ít hơn 5 kí tự
    public List<Genre> getGenresWithShortName() {
        return genreRepository.getByLengthOfCharacter();
    }

}
