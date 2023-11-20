package segundo.lenguajes.tarea2.modelos;

import java.util.Date;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="artista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Artistas {
    
    @Id
    @Column(name = "codigoartista")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoArtista;

    @Column(name = "nombreartistico")
    private String nombreArtistico;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechanacimiento")
    private Date fechaNacimiento;

    
    @JoinColumn(name = "codigocontacto", referencedColumnName ="codigocontacto")    
    @OneToOne(cascade = CascadeType.ALL)
    private informacionContactos informacioncontacto;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Canciones> cancion;
}
