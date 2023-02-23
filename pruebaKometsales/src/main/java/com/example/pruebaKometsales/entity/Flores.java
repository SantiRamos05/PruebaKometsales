package com.example.pruebaKometsales.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Esta clase define define la entidad para mantener y recuperar la informacion
 * @Param id
 * @Param name
 * @Param price
 *
 * Se utiliza la anotacion @Data de lombok para añadir los metodos getter, setter y añadir el constructor
 */

@Data
@Entity
public class Flores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
}
