package segundo.lenguajes.tarea2.servicios;

import java.util.List;

import segundo.lenguajes.tarea2.modelos.Artistas;
import segundo.lenguajes.tarea2.modelos.Canciones;

public interface ArtistaService {
    

    public Artistas guardarArtista(Artistas artista);

    public String eliminarArtista(int id);
    
    public Artistas buscarArtista(int id);

    public List<Artistas> obtenerArtistas();

    public List<Canciones> cancionesArtista(int id);

    public Artistas actualizarArtistaDireccion(int id, Artistas artista);

    public String asociarCancionArtistas(int idArtista, int idCancion);
}
