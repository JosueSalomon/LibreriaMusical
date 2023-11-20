package segundo.lenguajes.tarea2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import segundo.lenguajes.tarea2.modelos.Artistas;

public interface ArtistaRepository extends JpaRepository<Artistas, Integer> {
    
}
