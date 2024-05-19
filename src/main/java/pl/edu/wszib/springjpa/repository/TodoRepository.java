package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    int countByStatus(Todo.TodoStatus status);

    List<Todo> findAllByStatus(Todo.TodoStatus status);

    List<Todo> findTop3ByStatusIsNotOrderByDueDate(Todo.TodoStatus status);

}
