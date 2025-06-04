package tfg.warhammerScanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tfg.warhammerScanner.Repository.SubfactionRepository;
import tfg.warhammerScanner.entity.Subfaction;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")                 //Evitar problemas para cuando accedan aplicaciones externas a la API
@RequestMapping("/api")
public class SubfactionController {

    @Autowired
    private SubfactionRepository subfactionRepository;

    /*@GetMapping
    public List<Subfaction> getAll() {
        return subfactionRepository.findAllByOrderByNombreAsc();
    }*/

    @GetMapping("/subfacciones")
    public List<Subfaction> getAllById() {
        return subfactionRepository.findAllByOrderByIdAsc();
    }

}
