package pl.edu.wszib.springjpa.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.Prowadzacy;
import pl.edu.wszib.springjpa.model.Student;
import pl.edu.wszib.springjpa.model.Zajecia;
import pl.edu.wszib.springjpa.repository.ZajeciaRepository;

import java.util.List;

@Service
public class ZajeciaService implements CrudService<Zajecia, Long> {

    private final ZajeciaRepository repository;
    private final ProwadzacyService prowadzacyService;
    private final StudentService studentService;

    public ZajeciaService(ZajeciaRepository repository, ProwadzacyService prowadzacyService, StudentService studentService) {
        this.repository = repository;
        this.prowadzacyService = prowadzacyService;
        this.studentService = studentService;
    }

    @Override
    public List<Zajecia> list() {
        return repository.findAll();
    }

    @Override
    public Zajecia get(Long aLong) {
        return repository.findById(aLong)
                .get();
    }

    @Override
    public Zajecia create(Zajecia zajecia) {
        return repository.save(zajecia);
    }

    public Zajecia create(String nazwa, Long prowadzacyId) {
        Prowadzacy prowadzacy = prowadzacyService.get(prowadzacyId);
        Zajecia zajecia = new Zajecia();
        zajecia.setNazwa(nazwa);
        zajecia.setProwadzacy(prowadzacy);
        return repository.save(zajecia);
    }
    
    @Override
    public Zajecia update(Zajecia zajecia) {
        return repository.save(zajecia);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }

    public Zajecia dodajStudenta(Long zajeciaId, Long studentId) {
        Zajecia zajecia = get(zajeciaId);
        Student student = studentService.get(studentId);
        zajecia.getStudent().add(student);
        return repository.save(zajecia);
    }

    public Zajecia usunStudenta(Long zajeciaId, Long studentId) {
        Zajecia zajecia = get(zajeciaId);
        Student student = studentService.get(studentId);
        zajecia.getStudent().remove(student);
        return repository.save(zajecia);
    }
}
