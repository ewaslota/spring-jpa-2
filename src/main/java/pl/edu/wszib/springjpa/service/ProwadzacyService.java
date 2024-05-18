package pl.edu.wszib.springjpa.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.Prowadzacy;
import pl.edu.wszib.springjpa.repository.ProwadzacyRepository;

import java.util.List;

@Service
public class ProwadzacyService implements CrudService<Prowadzacy, Long> {

    private final ProwadzacyRepository repository;

    public ProwadzacyService(ProwadzacyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Prowadzacy> list() {
        return repository.findAll();
    }

    @Override
    public Prowadzacy get(Long aLong) {
        return repository.findById(aLong)
                .get();
    }

    @Override
    public Prowadzacy create(Prowadzacy organizacja) {
        return repository.save(organizacja);
    }

    @Override
    public Prowadzacy update(Prowadzacy organizacja) {
        return repository.save(organizacja);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }
}
