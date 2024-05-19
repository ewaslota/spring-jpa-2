package pl.edu.wszib.springjpa.service.dictionary;

import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.dictionary.Language;
import pl.edu.wszib.springjpa.repository.dictionary.LanguageRepository;
import pl.edu.wszib.springjpa.service.CrudService;

import java.util.List;

@Service
public class LanguageService implements CrudService<Language, Integer> {

    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    public Long count() {
        return repository.count();
    }

    public Language get(Integer id) {
        return repository.findById(id)
                .get();
    }

    @Override
    public List<Language> list() {
        return repository.findAll();
    }

    @Override
    public Language create(Language language) {
        return repository.save(language);
    }

    @Override
    public Language update(Language language) {
        return repository.save(language);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
