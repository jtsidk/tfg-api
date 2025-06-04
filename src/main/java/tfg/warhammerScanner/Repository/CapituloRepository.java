package tfg.warhammerScanner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tfg.warhammerScanner.entity.Capitulo;
import tfg.warhammerScanner.entity.Subfaction;

import java.util.List;

public interface CapituloRepository extends JpaRepository<Capitulo, Long>  {
    List<Capitulo> findByIdSubfaccionOrderByIdAsc(Long idSubfaccion);

}
