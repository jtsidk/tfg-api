package tfg.warhammerScanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tfg.warhammerScanner.Repository.CostRepository;
import tfg.warhammerScanner.Repository.InfoLinkRepository;
import tfg.warhammerScanner.Repository.SelectionEntryRepository;
import tfg.warhammerScanner.dto.StatisticsDTO;
import tfg.warhammerScanner.entity.Cost;
import tfg.warhammerScanner.entity.InfoLink;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class InfoLinkController {

    @Autowired
    private InfoLinkRepository infoLinkRepository;

    @Autowired
    private SelectionEntryRepository selectionEntryRepository;

    @Autowired
    private CostRepository costRepository;

    @GetMapping("/selection/{idSelection}")
    public ResponseEntity<List<InfoLink>> getInfoBySelection(@PathVariable Long idSelection) {
        List<InfoLink> infoList = infoLinkRepository.findByIdSelection(idSelection);
        if (infoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(infoList);
    }

    //Para las estadsticas de mis unidades
    @GetMapping("/estadisticas/{nombreUnidad}")
    public ResponseEntity<StatisticsDTO> getStatistics(@PathVariable String nombreUnidad) {
        List<Object[]> resultados = selectionEntryRepository.obtenerEstadisticasUnidad(nombreUnidad);

        if (resultados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Object[] raw = resultados.get(0); // ← primera fila del resultado

        StatisticsDTO dto = new StatisticsDTO();
        dto.setUnidad((String) raw[0]);
        dto.setM((String) raw[1]);
        dto.setT((String) raw[2]);
        dto.setW((String) raw[3]);
        dto.setLD((String) raw[4]);
        dto.setSV((String) raw[5]);
        dto.setOC((String) raw[6]);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/cost/{idSelection}")
    public ResponseEntity<Integer> getCostBySelection(@PathVariable Long idSelection) {
        List<Cost> costs = costRepository.findByIdSelectionAndName(idSelection, "pts");
        if (costs.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(costs.get(0).getValue());
    }

}
