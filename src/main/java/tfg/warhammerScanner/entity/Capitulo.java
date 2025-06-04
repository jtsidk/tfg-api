package tfg.warhammerScanner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chapters")
public class Capitulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_chapter")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="id_subfaction")
    private Long idSubfaccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdSubfaccion() {
        return idSubfaccion;
    }

    public void setIdSubfaccion(Long idSubfaccion) {
        this.idSubfaccion = idSubfaccion;
    }
}
