package com.example.pruebaKometsales.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase define define una clase para trasportar datos con los siguiente parametro
 * @Param name
 * @Param price
 *
 * Se utiliza la anotacion @Data de lombok para añadir los metodos getter, setter y añadir el constructor
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FloresDTO {
    String name;
    Double price;
}
