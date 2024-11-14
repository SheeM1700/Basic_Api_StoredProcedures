package com.StoredProcedure.Services;

import com.StoredProcedure.Persistence.entities.MovieEntity;
import com.StoredProcedure.Persistence.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional
    public List<MovieEntity> getAll(){
        return (List<MovieEntity>) this.movieRepository.verPeliculas();
    }

    @Transactional
    public MovieEntity getMovieById(Long id){
        return this.movieRepository.buscarPelicula(id);
    }

    @Transactional
    public void createMovie(MovieEntity movieEntity){
        movieRepository.insertarPelicula(
                movieEntity.getName(),
                movieEntity.getDescription(),
                movieEntity.getCategory(),
                movieEntity.getClassification());
    }

    @Transactional
    public void updateMovie(Long id, MovieEntity movieEntity){
        movieRepository.actualizarPelicula(
                id,
                movieEntity.getName(),
                movieEntity.getDescription(),
                movieEntity.getCategory(),
                movieEntity.getClassification());
    }

    @Transactional
    public void deleteMovie(Long id){
        movieRepository.eliminarPelicula(id);
    }


    
}