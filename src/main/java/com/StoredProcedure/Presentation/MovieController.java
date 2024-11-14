package com.StoredProcedure.Presentation;

import com.StoredProcedure.Persistence.entities.MovieEntity;
import com.StoredProcedure.Services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie/")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<MovieEntity>> finAll(){
        return new ResponseEntity<List<MovieEntity>>(this.movieService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MovieEntity> findById(@PathVariable Long id){
        return new ResponseEntity<>(this.movieService.getMovieById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createMovie(@RequestBody MovieEntity movieEntity){
        movieService.createMovie(movieEntity);
        return ResponseEntity.ok("Successfully created movie");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMovie(@PathVariable Long id, @RequestBody MovieEntity movieEntity){
        movieService.updateMovie(id, movieEntity);
        return ResponseEntity.ok("Successfully updated movie");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Successfully deleted movie");
    }
}
