package com.StoredProcedure.Persistence.repository;

import com.StoredProcedure.Persistence.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    @Procedure
    List<MovieEntity> verPeliculas();

    @Procedure
    MovieEntity buscarPelicula(Long id);

    @Procedure
    void insertarPelicula(@Param("name") String name,
                          @Param("description") String description,
                          @Param("category") String category,
                          @Param("classification") String classification);

    @Procedure
    void actualizarPelicula(@Param("id") Long id,
                            @Param("name") String name,
                            @Param("description") String description,
                            @Param("category") String category,
                            @Param("classification") String classification);

    @Procedure
    void eliminarPelicula(Long id);
}