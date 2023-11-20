package segundo.lenguajes.tarea2.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import segundo.lenguajes.tarea2.modelos.Artistas;
import segundo.lenguajes.tarea2.modelos.Canciones;
import segundo.lenguajes.tarea2.repositorios.ArtistaRepository;
import segundo.lenguajes.tarea2.repositorios.CancionesRepository;
import segundo.lenguajes.tarea2.servicios.ArtistaService;


@Service
public class ArtistaServiceImpl implements ArtistaService{

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private CancionesRepository cancioneRepository;


    @Override
    public Artistas guardarArtista(Artistas artista) {
        return artistaRepository.save(artista);
    }

    @Override
    public String eliminarArtista(int id) {
        Artistas artistaEliminar = this.artistaRepository.findById(id).get();

        if(artistaEliminar != null){
            this.artistaRepository.delete(artistaEliminar);
            return "Artista eliminado con exito";
        }

        return "Artista no encontrado";
    }

    @Override
    public Artistas buscarArtista(int id) {
        Artistas artistaEncontrado = this.artistaRepository.findById(id).get();

        if(artistaEncontrado != null) {
            return artistaEncontrado;
        }

        return null;
    }

    @Override
    public List<Artistas> obtenerArtistas() {
        return this.artistaRepository.findAll();
    }

    @Override
    public List<Canciones> cancionesArtista(int id) {
        return this.artistaRepository.findById(id).get().getCancion();
    }

    @Override
    public Artistas actualizarArtistaDireccion(int id, Artistas artista) {
        Artistas artistaActualizar = this.artistaRepository.findById(id).get();

        if(artistaActualizar != null) {
            artistaActualizar.getInformacioncontacto().setCiudad(artista.getInformacioncontacto().getCiudad());
            artistaActualizar.getInformacioncontacto().setPais(artista.getInformacioncontacto().getPais());
            this.artistaRepository.save(artistaActualizar);
            return artistaActualizar;
        }

        return null;
    }

    @Override
    public String asociarCancionArtistas(int idArtista, int idCancion) {
        Artistas artistaEncontrado = this.artistaRepository.findById(idArtista).get();
        Canciones  cancionEncontrada = this.cancioneRepository.findById(idCancion).get();
        if(artistaEncontrado != null && cancionEncontrada != null){
            return "Si existe el artista y la cancion";
        }
        return "No existe el artista y la cancion";
    }
}