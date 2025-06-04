package tfg.warhammerScanner.entity;

import jakarta.persistence.*;

@Entity
public class Subfaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_subfaction")
    private Long id;

    @Column(name="name")
    private String nombre;

    @Column(name="id_faction")
    private Long idFaccion;


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

    public Long getIdFaccion() {
        return idFaccion;
    }

    public void setIdFaccion(Long idFaccion) {
        this.idFaccion = idFaccion;
    }
}
