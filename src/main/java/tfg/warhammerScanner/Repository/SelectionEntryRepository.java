package tfg.warhammerScanner.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tfg.warhammerScanner.entity.SelectionEntry;

import java.util.List;

@Repository
public interface SelectionEntryRepository extends JpaRepository<SelectionEntry, Long> {
    List<SelectionEntry> findByIdChapterAndType(Long idChapter, String type);

    @Query(value = """
        SELECT
                          se.name AS unidad,
                          MAX(CASE WHEN c.name = 'M' THEN c.value END) AS M,
                          MAX(CASE WHEN c.name = 'T' THEN c.value END) AS T,
                          MAX(CASE WHEN c.name = 'W' THEN c.value END) AS W,
                          MAX(CASE WHEN c.name = 'LD' THEN c.value END) AS LD,
                          MAX(CASE WHEN c.name = 'SV' THEN c.value END) AS SV,
                          MAX(CASE WHEN c.name = 'OC' THEN c.value END) AS OC
                        FROM characteristic c
                        JOIN profile p ON c.id_profile = p.id_profile
                        JOIN selection_entry se ON p.id_selection = se.id_selection
                        WHERE se.name = :nombreUnidad AND p.type NOT IN ('Abilities')
                        GROUP BY se.name
    """, nativeQuery = true)
    List<Object[]> obtenerEstadisticasUnidad(@Param("nombreUnidad") String nombreUnidad);
}
