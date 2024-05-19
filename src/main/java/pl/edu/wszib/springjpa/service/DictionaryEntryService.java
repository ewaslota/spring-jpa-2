package pl.edu.wszib.springjpa.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.DictionaryEntry;
import pl.edu.wszib.springjpa.repository.DictionaryEntryRepository;

import java.util.List;

@Service
public class DictionaryEntryService implements CrudService<DictionaryEntry, Integer> {

    private final DictionaryEntryRepository repository;
    private final LanguageService languageService;

    public DictionaryEntryService(DictionaryEntryRepository repository, LanguageService languageService) {
        this.repository = repository;
        this.languageService = languageService;
    }

    public int count(String code) {
        if(code == null) {
            return (int) repository.count();
        }

        return repository.countByLanguageCode(code);
    }

    public List<DictionaryEntry> search(String text) {
        return repository.filterByText(text);
    }

    @Override
    public List<DictionaryEntry> list() {
        return repository.findAll();
    }

    @Override
    public DictionaryEntry get(Integer integer) {
        return repository.findById(integer).get();
    }

    @Override
    public DictionaryEntry create(DictionaryEntry dictionaryEntry) {
        dictionaryEntry.setId(null);
        dictionaryEntry.setLanguage(
                languageService.get(
                        dictionaryEntry.getLanguage().getId()
                )
        );
        return repository.save(dictionaryEntry);
    }

    @Override
    public DictionaryEntry update(DictionaryEntry dictionaryEntry) {
        DictionaryEntry existing = get(dictionaryEntry.getId());
        existing.setDescription(dictionaryEntry.getDescription());
        existing.setLanguage(
                languageService.get(
                        dictionaryEntry.getLanguage().getId()
                )
        );
        existing.setWord(dictionaryEntry.getWord());
        existing.setTranslation(dictionaryEntry.getTranslation());
        return repository.save(existing);
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }
}
