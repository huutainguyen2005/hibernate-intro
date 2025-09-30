package app.services;

import app.entities.Genre;
import app.repositories.GenreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Page<Genre> getByGenreNameContainingIgnoreCase(String name, Pageable pageable) {
        return genreRepository.getByGenreNameContainingIgnoreCase(name, pageable);
    }

    //Lấy danh sách các Genre có tên ít hơn 5 kí tự
    public List<Genre> getGenresWithShortName() {
        return genreRepository.getByLengthOfCharacter();
    }

    //Reference
    public Genre getReferenceById(int id) {
        return  genreRepository.getByGenreId(id);
    }

    //SELECT name from genre where genreid = ?
    @Transactional
    public String getGenreNameById(int id) {
        Genre g = genreRepository.getByGenreId(id);
        System.out.println("After getReference");
        System.out.println("Before getReference");
        return g.getGenreName();
    }
    
    @Transactional
    public void renameById(int id, String newName) {
        //tx = transaction
        Genre g =  genreRepository.getReferenceById(id);
        g.setGenreName(newName);
        //genreRepository.save(g);
        //commit tx
    }
}
