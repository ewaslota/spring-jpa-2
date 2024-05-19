package pl.edu.wszib.springjpa.controller.dictionary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.springjpa.model.dictionary.DictionaryEntry;
import pl.edu.wszib.springjpa.service.dictionary.DictionaryEntryService;

import java.util.List;

@RestController
public class DictionaryEntryController {

    private final DictionaryEntryService service;

    public DictionaryEntryController(DictionaryEntryService service) {
        this.service = service;
    }

    @GetMapping ("/dictionary/entry")
    public List<DictionaryEntry> list() {
        return service.list;
    }

    @GetMapping ("/dictionary/entry/property/count")
    public Long count() {
        return service.count();
    }
}
