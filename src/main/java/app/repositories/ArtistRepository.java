package app.repositories;

import app.entities.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{

    //Magic methods
    //List - Search feature: Get by name
    List<Artist> getByNameContainingIgnoreCase(String name);

    List<Artist> getByArtistIdGreaterThan(int artistId);

    Page<Artist> getByNameContainingIgnoreCase(String name, Pageable pageable);

    //Lấy theo ID
    Artist getByArtistId(int id);


}
