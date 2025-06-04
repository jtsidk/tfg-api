package tfg.warhammerScanner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.warhammerScanner.entity.Subfaction;

import java.util.List;

public interface SubfactionRepository extends JpaRepository<Subfaction, Long> {
    List<Subfaction> findAllByOrderByNombreAsc();

    List<Subfaction> findAllByOrderByIdAsc();
}
