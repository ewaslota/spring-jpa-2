package pl.edu.wszib.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.DictionaryEntry;
import pl.edu.wszib.springjpa.model.Language;
import pl.edu.wszib.springjpa.service.DictionaryEntryService;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary/entry")
public class DictionaryEntryController {

    private final DictionaryEntryService service;

    public DictionaryEntryController(DictionaryEntryService service) {
        this.service = service;
    }

    @GetMapping("/property/count")
    public int count(@RequestParam(required = false) String code) {
        return service.count(code);
    }

    @GetMapping("/operation/search")
    public List<DictionaryEntry> search(@RequestParam String text) {
        return service.search(text);
    }

    @GetMapping
    public List<DictionaryEntry> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public DictionaryEntry get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public DictionaryEntry create(@RequestBody DictionaryEntry entry) {
        return service.create(entry);
    }

    @PutMapping
    public DictionaryEntry update(@RequestBody DictionaryEntry entry) {
        return service.update(entry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
