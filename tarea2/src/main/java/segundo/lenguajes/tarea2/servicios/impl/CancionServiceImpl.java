package segundo.lenguajes.tarea2.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import segundo.lenguajes.tarea2.modelos.Artistas;
import segundo.lenguajes.tarea2.modelos.Canciones;
import segundo.lenguajes.tarea2.repositorios.ArtistaRepository;
import segundo.lenguajes.tarea2.repositorios.CancionesRepository;
import segundo.lenguajes.tarea2.servicios.CancionService;

@Service
public class CancionServiceImpl implements CancionService {

    @Autowired
    private CancionesRepository cancionesRepository;

    @Autowired
    private ArtistaRepository artistasRepository;


    @Override
    public Artistas agregarCancionArtista(int id, Canciones cancion) {
        Artistas artist = this.obtenerArtistas(id);
        if(artist !=null){
            cancion.setArtista(artist);
            this.cancionesRepository.save(cancion);
        }

        return artist;
    }
    

    private Artistas obtenerArtistas(int id){
        return this.artistasRepository.findById(id).get();
    }


    @Override
    public String eliminarCancion(int id) {
        Canciones cancionElimar = this.cancionesRepository.findById(id).get();

        if(cancionElimar != null){
            this.cancionesRepository.delete(cancionElimar);
            return "Cancion eliminada con exito";
        }

        return "Cancion no encontrado";
    }
}
