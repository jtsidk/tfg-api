package tfg.warhammerScanner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tfg.warhammerScanner.entity.Cost;

import java.util.List;
import java.util.Optional;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {

    List<Cost> findByIdSelectionAndName(Long idSelection, String name);
}
