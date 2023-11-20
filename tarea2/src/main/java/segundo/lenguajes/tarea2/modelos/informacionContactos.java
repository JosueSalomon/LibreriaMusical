package segundo.lenguajes.tarea2.modelos;



import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="informacioncontacto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class informacionContactos {
    
    @Id
    @Column(name = "codigocontacto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoContacto;

    @Column(name = "pais")
    private String pais;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "telefono")
    private String telefono;

    
    @Column(name = "correo")
    private String correo;

    @JsonIgnore
    @OneToOne(mappedBy = "informacioncontacto")    
    private Artistas artista;
}
