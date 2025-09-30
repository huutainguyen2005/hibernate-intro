package app.service;

import app.entities.Artist;
import app.repositories.ArtistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    //Dependency Injection
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    //Business logic
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public List<Artist> getArtistByName(String name) {
        return artistRepository.getByNameContainingIgnoreCase(name);
    }

    public List<Artist> getArtistWithIdGreaterThan(int id) {
        return artistRepository.getByArtistIdGreaterThan(id);
    }

    public Page<Artist> getByNameContainingIgnoreCase(String name, Pageable pageable) {
        return artistRepository.getByNameContainingIgnoreCase(name, pageable);
    }

    public Artist getByArtistId1(int id) {
        return artistRepository.getByArtistId(id);
    }

    public Artist getByArtistId2(int id) {
        //Optional<Artist> artistOptional = artistRepository.findById(id);
        //if (artistOptional.isPresent()) {
        //    return artistOptional.get();
        //} else {
        //    return null;
        //}

        return artistRepository
                .findById(id)
                .orElse(new Artist(0, "Nghe si mac dinh"));
    }

}
