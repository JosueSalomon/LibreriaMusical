package segundo.lenguajes.tarea2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import segundo.lenguajes.tarea2.modelos.Canciones;

public interface CancionesRepository extends JpaRepository<Canciones, Integer> {
    
}
