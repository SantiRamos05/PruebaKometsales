package com.example.pruebaKometsales.entity;


import lombok.Data;

/**
 * Esta clase define definen la parametros de la clase Flor para crear la lista de flores en el controlador FloresControllerLista
 * @Param id
 * @Param name
 * @Param price
 *
 * Se utiliza la anotacion @Data de lombok para añadir los metodos getter, setter y añadir el constructor
 */

@Data
public class Flor {

    private int id;
    private String name;
    private Double price;


}
