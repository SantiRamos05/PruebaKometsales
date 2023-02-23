package com.example.pruebaKometsales.repository;

import com.example.pruebaKometsales.entity.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfas define define el repositorio que extiende de jpa y asi permite interactuar con la base de datos
 */
@Repository
public interface FloresRepository extends JpaRepository<Flores, Integer> {
}
