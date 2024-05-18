package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.Prowadzacy;
import pl.edu.wszib.springjpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
