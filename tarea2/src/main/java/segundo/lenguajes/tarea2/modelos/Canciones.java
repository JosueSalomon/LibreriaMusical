package segundo.lenguajes.tarea2.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="canciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Canciones {
    
    @Id
    @Column(name = "codigocancion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCancion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "album")
    private String album;

    @Column(name="anyolanzamiento")
    private int anyolanzamiento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="codigoartista", referencedColumnName = "codigoartista")
    private Artistas artista;
}
