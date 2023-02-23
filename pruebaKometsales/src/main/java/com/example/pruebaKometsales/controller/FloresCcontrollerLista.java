package com.example.pruebaKometsales.controller;

import com.example.pruebaKometsales.DTO.FloresDTO;
import com.example.pruebaKometsales.entity.Flor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta clase de tipo @RestController se implementan los diferentes metodos necesarios
 */
@RestController
public class FloresCcontrollerLista {

    /**
     * Variable de tipo static que guarda una lista de flores
     */
    private static List<Flor> flores;

    /**
     * Metodo guardarFlores de tipo @PostMapping que recibe una lista de objetos Flor
     * Luego guarda esa lista en la variable static flores
     */
    @PostMapping("/lista")
    public void guardarFlores(@RequestBody List<Flor> flores) {
        FloresCcontrollerLista.flores = flores;
    }

    /**
     * Metodo obtenerFlores de tipo @GetMapping que devuelve una lista de objetos FloresDTO
     * Se ordenan los datos y se modifica el campo name para agregar "-kometsales"
     */
    @GetMapping("/lista")
    public List<FloresDTO> obtenerFlores() {
        return flores.stream()
                .sorted(Comparator.comparing(Flor::getName).reversed())
                .map(flor -> new FloresDTO(flor.getName() + "-kometsales", flor.getPrice()))
                .collect(Collectors.toList());
    }


    /**
     * Metodo getFloresMayores20 de tipo @GetMapping que devuelve una lista de objetos Flor
     * Se obtiene la lista de todas las flores almacenadas en la variable static flores
     * Se filtra la lista utilizando el método filter
     */
    @GetMapping("/lista/mayor-20")
    public List<Flor> getFloresMayores20(HttpServletRequest request) {
        List<Flor> todasFlores = FloresCcontrollerLista.flores;
        List<Flor> filteredFlowers = todasFlores.stream()
                .filter(f -> f.getPrice() > 20)
                .collect(Collectors.toList());
        return filteredFlowers;
    }


    /**
     * Metodo borrarFlor de tipo @DeleteMapping elimina una flor de la lista a traves de su id
     * Se obtiene la lista de todas las flores almacenadas en la variable static flores
     * Se filtra la lista utilizando el método filter para buscar el id
     * Se realiza una condicion en donde si no encuentra un id devuelve un badRequest(), sino devuelve un codigo 200 ok
     */
    @DeleteMapping("/lista/{id}")
    public ResponseEntity<String> borrarFlor(HttpServletRequest request, @PathVariable int id) {
        List<Flor> todasFlores = FloresCcontrollerLista.flores;
        List<Flor> filtrarFlores = todasFlores.stream()
                .filter(f -> f.getId() != id)
                .collect(Collectors.toList());
        if (filtrarFlores.size() == todasFlores.size()) {
            return ResponseEntity.badRequest().body("No se encontró la flor con id " + id);
        } else {
            FloresCcontrollerLista.flores = filtrarFlores;
            return ResponseEntity.ok().body("La flor con id " + id + " ha sido eliminada");
        }
    }


    /**
     * Metodo buscarFlorPorNombre de tipo @GetMapping busca una flor atraves de su name
     * Se obtiene la lista de todas las flores almacenadas en la variable static flores
     * Se filtra la lista utilizando el método filter para buscar el name
     * Devuelve las flores que coincidan con el name
     */
    @GetMapping("/lista/name")
    public List<Flor> buscarFlorPorNombre(HttpServletRequest request, @RequestParam String name) {
        List<Flor> todasFlores = FloresCcontrollerLista.flores;
        List<Flor> filtrarFlores = todasFlores.stream()
                .filter(f -> f.getName().contains(name))
                .collect(Collectors.toList());
        return filtrarFlores;
    }





}
