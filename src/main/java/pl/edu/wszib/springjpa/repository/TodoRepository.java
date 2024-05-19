package pl.edu.wszib.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.springjpa.model.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    int countByStatus(Todo.TodoStatus status);

    List<Todo> findAllByStatus(Todo.TodoStatus status);

    List<Todo> findTop3ByStatusIsNotOrderByDueDateAsc(Todo.TodoStatus status);

    @Query(value = "select top 3 * from todo where status != 'COMPLETED' order by due_date", nativeQuery = true)
    List<Todo> upcoming();
}
