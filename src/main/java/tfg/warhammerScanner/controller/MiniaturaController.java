package tfg.warhammerScanner.controller;

import org.springframework.web.bind.annotation.*;
import tfg.warhammerScanner.Repository.MiniaturaRepository;
import tfg.warhammerScanner.entity.Miniatura;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")                 //Evitar problemas para cuando accedan aplicaciones externas a la API
@RequestMapping("/api")
public class MiniaturaController {

    private final MiniaturaRepository miniaturaRepository;

    public MiniaturaController(MiniaturaRepository miniaturaRepository) {
        this.miniaturaRepository = miniaturaRepository;
    }

    @GetMapping
    public List<Miniatura> getAllMiniaturas() {
        return miniaturaRepository.findAll();
    }

    @GetMapping("/miniaturas/{id}")
    public Optional<Miniatura> getMiniaturaById(@PathVariable Long id) {
        return miniaturaRepository.findById(id);
    }

    @GetMapping("/search")
    public List<Miniatura> searchByNombre(@RequestParam String nombre) {
        return miniaturaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @GetMapping("/type")
    public List<Miniatura> searchByTipo(@RequestParam String tipo) {
        return miniaturaRepository.findByTipoContainingIgnoreCase(tipo);
    }

}
