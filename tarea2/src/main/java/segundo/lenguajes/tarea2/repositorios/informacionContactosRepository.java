package segundo.lenguajes.tarea2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import segundo.lenguajes.tarea2.modelos.informacionContactos;

public interface informacionContactosRepository extends JpaRepository<informacionContactos, Integer>{
    
}
