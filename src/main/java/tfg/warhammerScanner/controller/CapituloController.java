package tfg.warhammerScanner.controller;

import org.springframework.web.bind.annotation.*;
import tfg.warhammerScanner.Repository.CapituloRepository;
import tfg.warhammerScanner.Repository.MiniaturaRepository;
import tfg.warhammerScanner.entity.Capitulo;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")                 //Evitar problemas para cuando accedan aplicaciones externas a la API
@RequestMapping("/api")
public class CapituloController {

     final CapituloRepository capituloRepository;

    public CapituloController(CapituloRepository capituloRepository) {
        this.capituloRepository = capituloRepository;
    }

    @GetMapping("/capitulos")
    public List<Capitulo> getChaptersBySubfactionId(@RequestParam Long idSubfaccion) {
        return capituloRepository.findByIdSubfaccionOrderByIdAsc(idSubfaccion);
    }

}
