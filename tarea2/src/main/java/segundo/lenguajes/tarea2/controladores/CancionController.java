package segundo.lenguajes.tarea2.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import segundo.lenguajes.tarea2.modelos.Canciones;
import segundo.lenguajes.tarea2.servicios.impl.CancionServiceImpl;


@RestController
@RequestMapping("/api/canciones")
public class CancionController {
    
    @Autowired
    private CancionServiceImpl CancionServiceImpl;

    @PostMapping("/add/{codigoArtista}")
    public String agregarCancionArtista(@PathVariable(name="codigoArtista") int codigoArtista, @RequestBody Canciones cancion){
        if(this.CancionServiceImpl.agregarCancionArtista(codigoArtista, cancion) != null){
            return "Se agrego la cancion al artista";
        }

        return "No se agrego la cancion al artista";
    }

    @DeleteMapping("/eliminar/{codigocancion}")
    public String eliminarCancion(@PathVariable(name="codigocancion") int codigocancion) {
        return this.CancionServiceImpl.eliminarCancion(codigocancion);
    }
}
