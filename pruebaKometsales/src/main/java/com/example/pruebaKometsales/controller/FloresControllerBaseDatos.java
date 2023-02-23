package com.example.pruebaKometsales.controller;

import com.example.pruebaKometsales.DTO.FloresDTO;
import com.example.pruebaKometsales.DTO.Mensaje;
import com.example.pruebaKometsales.entity.Flores;
import com.example.pruebaKometsales.service.FlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase de tipo @RestController todos los metodos necesarios para implementar los servicios
 */
@RestController
public class FloresControllerBaseDatos {

    @Autowired
    FlorService florService;


    /**
     * Metodo create de tipo @PostMapping que ejecuta el el servicio florService.guardar()
     * Retorna un Mensaje con un status de created
     */
    @PostMapping("/flores")
    public ResponseEntity<?> create(@RequestBody Flores flores){
        florService.guardar(flores);
        return new ResponseEntity<>(new Mensaje("producto guardado"), HttpStatus.CREATED);
    }

    /**
     * Metodo getLista de tipo @GetMapping que devuelve una lista de objetos FloresDTO
     * Retorna un lista de flores
     */
    @GetMapping("/flores")
    public ResponseEntity<List<FloresDTO>> getLista(){
        List<FloresDTO> lista = florService.obtenerTodos();
        return new ResponseEntity<List<FloresDTO>>(lista, HttpStatus.OK);
    }

    /**
     * Metodo getListaPrecioMayor de tipo @GetMapping que devuelve una lista de Flores
     * Retorna un lista de flores
     */
    @GetMapping("/flores-mayor")
    public ResponseEntity<List<Flores>> getListaPrecioMayor(){
        List<Flores> lista = florService.obtenerFloresConPrecioMayor();
        return new ResponseEntity<List<Flores>>(lista, HttpStatus.OK);
    }


    /**
     * Metodo delete de tipo @DeleteMapping que elimina una flor a traves de si id
     * Retorna un Mensaje con un status de created
     */
    @DeleteMapping("/flores/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        florService.borrar(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.CREATED);
    }

    /**
     * Metodo getListaNombre de tipo @GetMapping que devuelve una lista de Flores
     * Retorna un lista de flores
     */
    @GetMapping("/flores/name")
    public ResponseEntity<List<Flores>> getListaNombre(@RequestParam String name){
        List<Flores> lista = florService.obtenerFloresPorNombre(name);
        return new ResponseEntity<List<Flores>>(lista, HttpStatus.OK);
    }




}
