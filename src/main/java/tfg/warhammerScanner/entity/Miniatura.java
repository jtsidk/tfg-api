package tfg.warhammerScanner.entity;

import jakarta.persistence.*;

@Entity
@Table(name="selection_entry")
public class Miniatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_selection")
    private Long id;
    @Column(name="name")
    private String nombre;
    @Column(name="type")
    private String tipo;

    public Miniatura () {}          //Necesario para JPA

    public Miniatura(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
