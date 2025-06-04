package tfg.warhammerScanner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cost")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cost")
    private Long idCost;

    @Column(name="id_selection")
    private Long idSelection;

    @Column(name="name")
    private String name;

    @Column(name="value")
    private Integer value;


    public Long getIdCost() {
        return idCost;
    }

    public void setIdCost(Long idCost) {
        this.idCost = idCost;
    }

    public Long getIdSelection() {
        return idSelection;
    }

    public void setIdSelection(Long idSelection) {
        this.idSelection = idSelection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
