package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.Student;
import pl.edu.wszib.springjpa.model.Zajecia;

import java.util.List;

@Repository
public interface ZajeciaRepository extends JpaRepository<Zajecia, Long> {

    List<Zajecia> findByNazwaContainingIgnoreCaseAndStudentId(String nazwa, Long studentId);

}
