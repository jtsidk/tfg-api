package tfg.warhammerScanner.entity;

import jakarta.persistence.*;

@Entity
@Table(name="info_link")
public class InfoLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_info_link")
    private Long idInfoLink;
    @Column(name="id_selection")
    private Long idSelection;
    @Column(name="description")
    private String description;
    @Column(name="image_url")
    private String imageUrl;

    public Long getIdInfoLink() {
        return idInfoLink;
    }

    public void setIdInfoLink(Long idInfoLink) {
        this.idInfoLink = idInfoLink;
    }

    public Long getIdSelection() {
        return idSelection;
    }

    public void setIdSelection(Long idSelection) {
        this.idSelection = idSelection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
