package pl.edu.wszib.springjpa.controller.dictionary;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.dictionary.Language;
import pl.edu.wszib.springjpa.service.dictionary.LanguageService;

import java.util.List;

@RestController
public class LanguageController {
    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping("/dictionary/language")
    public List<Language> list() {
        return service.list();
    }

    @GetMapping ("/dictionary/language/property/count")
    public Long count() {
        return service.count();
    }

    @GetMapping ("/dictionary/language/{id}")
    public Language get(@PathVariable Integer id) {
        return service.get(id);
    }

    @DeleteMapping("/dictionary/language/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PostMapping ("/dictionary/language")
    public Language create(@RequestBody Language language) {
        return service.create(language);
    }

    @PutMapping ("/dictionary/language")
    public Language update(Language language) {
        return service.update(language);
    }
}
