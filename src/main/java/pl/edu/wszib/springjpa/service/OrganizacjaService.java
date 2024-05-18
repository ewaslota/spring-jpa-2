package pl.edu.wszib.springjpa.service;
import pl.edu.wszib.springjpa.model.Organizacja;
import pl.edu.wszib.springjpa.repository.OrganizacjaRepository;

import java.util.List;

public class OrganizacjaService implements CrudService<Organizacja, Long> {

    private final OrganizacjaRepository repository;

    public OrganizacjaService(OrganizacjaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Organizacja> list() {
        return repository.findAll();
    }

    @Override
    public Organizacja get(Long aLong) {
        return repository.findById(aLong)
        .get();
    }

    @Override
    public Organizacja create(Organizacja organizacja) {
        return repository.save(organizacja);
    }

    @Override
    public Organizacja update(Organizacja organizacja) {
        return repository.save(organizacja);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);

    }
}
