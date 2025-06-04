package tfg.warhammerScanner.controller;

import org.springframework.web.bind.annotation.*;
import tfg.warhammerScanner.Repository.SelectionEntryRepository;
import tfg.warhammerScanner.entity.SelectionEntry;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class SelectionEntryController {

    private final SelectionEntryRepository selectionEntryRepository;

    public SelectionEntryController(SelectionEntryRepository selectionEntryRepository) {
        this.selectionEntryRepository=selectionEntryRepository;
    }

    @GetMapping("/models")
    public List<SelectionEntry> getModels(@RequestParam Long idChapter) {
        return selectionEntryRepository.findByIdChapterAndType(idChapter, "model");
    }

    @GetMapping("/upgrades")
    public List<SelectionEntry> getUpgrades(@RequestParam Long idChapter) {
        return selectionEntryRepository.findByIdChapterAndType(idChapter, "upgrade");
    }

    @GetMapping("/units")
    public List<SelectionEntry> getUnits(@RequestParam Long idChapter) {
        return selectionEntryRepository.findByIdChapterAndType(idChapter, "unit");
    }
}
