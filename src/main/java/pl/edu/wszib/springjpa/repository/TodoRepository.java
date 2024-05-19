package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
