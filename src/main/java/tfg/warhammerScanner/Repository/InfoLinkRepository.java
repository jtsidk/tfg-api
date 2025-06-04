package tfg.warhammerScanner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.warhammerScanner.entity.InfoLink;

import java.util.List;

public interface InfoLinkRepository extends JpaRepository<InfoLink, Long> {
        List<InfoLink> findByIdSelection(Long idSelection);

}
