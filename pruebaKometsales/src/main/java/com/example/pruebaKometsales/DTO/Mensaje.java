package com.example.pruebaKometsales.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase define define una clase para trasportar datos con el siguiente parametro
 * @Param mensaje
 *
 * Se utiliza la anotacion @Data de lombok para añadir los metodos getter, setter y añadir el constructor
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mensaje {
    private String mensaje;
}
