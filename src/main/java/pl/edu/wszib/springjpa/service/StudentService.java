package pl.edu.wszib.springjpa.service;

import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.Student;
import pl.edu.wszib.springjpa.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService implements CrudService<Student, Long> {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> list() {
        return repository.findAll();
    }

    @Override
    public Student get(Long aLong) {
        return repository.findById(aLong)
                .get();
    }

    @Override
    public Student create(Student organizacja) {
        return repository.save(organizacja);
    }

    @Override
    public Student update(Student organizacja) {
        return repository.save(organizacja);
    }

    @Override
    public void delete(Long aLong) {
        repository.deleteById(aLong);
    }
}
