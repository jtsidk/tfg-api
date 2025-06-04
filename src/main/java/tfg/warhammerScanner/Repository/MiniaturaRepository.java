package tfg.warhammerScanner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.warhammerScanner.entity.Miniatura;

import java.util.List;

public interface MiniaturaRepository extends JpaRepository<Miniatura, Long> {
    List<Miniatura> findByNombreContainingIgnoreCase(String nombre);
    List<Miniatura> findByTipoContainingIgnoreCase(String tipo);
}
