package pl.edu.wszib.springjpa.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.Language;
import pl.edu.wszib.springjpa.repository.LanguageRepository;

import java.util.List;

@Service
public class LanguageService implements CrudService<Language, Integer> {

    private final LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }


    public int count() {
        return (int) repository.count();
    }

    @Override
    public List<Language> list() {
        return repository.findAll();
    }

    @Override
    public Language get(Integer integer) {
        return repository.findById(integer).get();
    }

    @Override
    public Language create(Language language) {
        language.setId(null);
        return repository.save(language);
    }

    @Override
    public Language update(Language language) {
        Language existing = get(language.getId());
        existing.setCode(language.getCode());
        existing.setName(language.getName());
        return repository.save(existing);
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }
}
