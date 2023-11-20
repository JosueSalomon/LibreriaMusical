package segundo.lenguajes.tarea2.servicios;

import segundo.lenguajes.tarea2.modelos.Artistas;
import segundo.lenguajes.tarea2.modelos.Canciones;

public interface CancionService {
    
    public Artistas agregarCancionArtista(int id, Canciones cancion);

    public String eliminarCancion(int id);
}
