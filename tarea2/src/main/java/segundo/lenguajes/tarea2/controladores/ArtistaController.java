package segundo.lenguajes.tarea2.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import segundo.lenguajes.tarea2.modelos.Artistas;
import segundo.lenguajes.tarea2.modelos.Canciones;
import segundo.lenguajes.tarea2.servicios.impl.ArtistaServiceImpl;


@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {
    

    @Autowired
    private ArtistaServiceImpl artistaServiceImpl;

    @PostMapping("/guardar")
    public Artistas guardarArtista(@RequestBody Artistas nvoArtista) {
        if(nvoArtista.getInformacioncontacto().getArtista() != null){
            nvoArtista.getInformacioncontacto().setArtista(nvoArtista);
        }
        return artistaServiceImpl.guardarArtista(nvoArtista);
    }

    @PutMapping("/actualizarDireccion/{codigoArtista}")
    public Artistas actualizarArtistaDireccion(@PathVariable(name="codigoArtista") int codigoArtista,@RequestBody Artistas artista){
        return this.artistaServiceImpl.actualizarArtistaDireccion(codigoArtista, artista);
    }

    @DeleteMapping("/eliminar/{codigoArtista}")
    public String eliminarArtista(@PathVariable(name="codigoArtista") int codigoArtista) {
        return artistaServiceImpl.eliminarArtista(codigoArtista);
    }

    @GetMapping("buscar/{codigoArtista}")
    public Artistas buscarArtista(@PathVariable(name="codigoArtista") int codigoArtista) {
        return artistaServiceImpl.buscarArtista(codigoArtista);
    }

    @GetMapping("/obtenerArtistas")
    public List<Artistas> obtenerArtistas() {
        return artistaServiceImpl.obtenerArtistas();
    }

    @GetMapping("cancionesArtista/{codigoArtista}")
    public List<Canciones> cancionesArtista(@PathVariable(name="codigoArtista") int codigoArtista) {
        return artistaServiceImpl.cancionesArtista(codigoArtista);
    }

    @PostMapping("/asociarCancionArtistas")
    public String asociarCancionArtistas(@RequestBody Integer codigoArtista, Integer codigoCancion )  {
        return artistaServiceImpl.asociarCancionArtistas(codigoArtista,codigoCancion);
    }
    
}
