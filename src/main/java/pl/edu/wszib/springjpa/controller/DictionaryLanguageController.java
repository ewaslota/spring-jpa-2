package pl.edu.wszib.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Language;
import pl.edu.wszib.springjpa.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary/language")
public class DictionaryLanguageController {

    private final LanguageService service;

    public DictionaryLanguageController(LanguageService service) {
        this.service = service;
    }

    @GetMapping("/property/count")
    public int count() {
        return service.count();
    }


    @GetMapping
    public List<Language> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Language get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public Language create(@RequestBody Language language) {
        return service.create(language);
    }

    @PutMapping
    public Language update(@RequestBody Language language) {
        return service.update(language);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
