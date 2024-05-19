package pl.edu.wszib.springjpa.service.dictionary;

import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.dictionary.DictionaryEntry;
import pl.edu.wszib.springjpa.repository.dictionary.DictionaryEntryRepository;
import pl.edu.wszib.springjpa.service.CrudService;

import java.util.List;

@Service
public class DictionaryEntryService implements CrudService<DictionaryEntry, Integer> {

    private final DictionaryEntryRepository repository;
    public List<DictionaryEntry> list;

    public DictionaryEntryService(DictionaryEntryRepository repository) {
        this.repository = repository;
    }

    public Long count() {
        return repository.count();
    }
    @Override
    public List<DictionaryEntry> list() {
        return null;
    }

    @Override
    public DictionaryEntry get(Integer integer) {
        return null;
    }

    @Override
    public DictionaryEntry create(DictionaryEntry dictionaryEntry) {
        return null;
    }

    @Override
    public DictionaryEntry update(DictionaryEntry dictionaryEntry) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
