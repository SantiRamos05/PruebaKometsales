package com.example.pruebaKometsales.service;

import com.example.pruebaKometsales.DTO.FloresDTO;
import com.example.pruebaKometsales.entity.Flores;
import com.example.pruebaKometsales.repository.FloresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Esta clase de tipo @Servicie contiene la logica que se implementa en cada metodo
 */
@Service
public class FlorService {

    @Autowired
    FloresRepository floresRepository;

    /**
     * Servicio que se encarga de guardar la flores
     */
    public void guardar(Flores flores){
        floresRepository.save(flores);
    }

    /**
     * Servicio que se encarga de obtener las flores por name y price
     * Tambien se encarga de añadir "-kometsales" al name de la flor
     */
    public List<FloresDTO> obtenerTodos(){
        List<Flores> lista = floresRepository.findAll();

        // Se crea una lista de DTOs de flores
        List<FloresDTO> listaDTOs = new ArrayList<>();

        // Se recorre la lista de flores original y se crea un DTO para cada objeto
        for (Flores flor : lista) {
            String name = flor.getName() + "-kometsales";
            Double price = flor.getPrice();
            FloresDTO florDTO = new FloresDTO(name, price);
            listaDTOs.add(florDTO);
        }
        // Se ordena la lista de DTOs alfabéticamente de manera descendente
        listaDTOs.sort(Comparator.comparing(FloresDTO::getName).reversed());

        return listaDTOs;
    }

    /**
     * Servicio que se encarga de obtener las flores con el precio mayor a 20
     *
     */
    public List<Flores> obtenerFloresConPrecioMayor() {
        List<Flores> lista = floresRepository.findAll();
        List<Flores> listaFiltrada = new ArrayList<>();
        Double precioMinimo = Double.valueOf(20);

        // Se recorre la lista de flores y se filtran las que tienen un precio mayor a 20
        for (Flores flor : lista) {
            if (flor.getPrice().compareTo(precioMinimo) > 0) {
                listaFiltrada.add(flor);
            }
        }
        return listaFiltrada;
    }

    /**
     * Servicio que se encarga de borrar flores por el numero de id
     */
    public void borrar(Integer id){
        floresRepository.deleteById(id);
    }

    /**
     * Servicio que se encarga de obtener las flores por name y price
     * Tambien se encarga de añadir "-kometsales" al name de la flor
     */
    public List<Flores> obtenerFloresPorNombre(String nombre) {
        List<Flores> lista = floresRepository.findAll();
        List<Flores> listaFiltrada = new ArrayList<>();

        // Se recorre la lista de flores y se filtran las que tienen el nombre indicado
        for (Flores flor : lista) {
            if (flor.getName().equals(nombre)) {
                listaFiltrada.add(flor);
            }
        }

        return listaFiltrada;
    }
}
