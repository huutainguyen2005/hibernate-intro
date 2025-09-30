package app.repositories;

import app.entities.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre,Integer> {
    //Bi tap:
    //1. Viết Entity Genre
    //2. Viết Repository cho Entity Genre
    //3. Viết Service cho Entity Genre

    //4. Viết 1 số phương thức trong Repo và Service
    //List, có phân trang. Get by ID

    //5. Nghiên cứu và viết 1 phương thức có custom query
    //Phương thức này sẽ lấy danh sách các Genre mà tên ngắn hơn 5 kí tự

    Genre getByGenreId(int genreId);

    Page<Genre> getByGenreNameContainingIgnoreCase(String name, Pageable pageable);

    //@Query(value = "select * from genre where len(name) < 5", nativeQuery = true)
    //List<Genre> getByLengthOfCharacter();

    //HQL - Hibernate Query Language
    @Query(value = "select g from Genre g where len(g.genreName) < 5")
    List<Genre> getByLengthOfCharacter();

    //Hibernate Query Language (HQL)
    //SQL
    //Framework Thymeleaf
}
