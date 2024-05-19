package pl.edu.wszib.springjpa.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.edu.wszib.springjpa.model.Todo;
import pl.edu.wszib.springjpa.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService implements CrudService<Todo, Integer> {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Todo> list() {
        return repository.findAll();
    }

    public List<Todo> list(String order) {
        return repository.findAll(
                Sort.by(
                        order.equals("asc") ?
                                Sort.Direction.ASC :
                                Sort.Direction.DESC,
                        "title"
                )
        );
    }

    @Override
    public Todo get(Integer integer) {
        return repository.findById(integer).get();
    }

    @Override
    public Todo create(Todo todo) {
        todo.setId(null);
        todo.setStatus(Todo.TodoStatus.NEW);
        return repository.save(todo);
    }

    @Override
    public Todo update(Todo todo) {
        Todo existing = get(todo.getId());
        existing.setDueDate(todo.getDueDate());
        existing.setTitle(todo.getTitle());
        existing.setStatus(todo.getStatus());
        return repository.save(existing);
    }

    @Override
    public void delete(Integer integer) {
        repository.deleteById(integer);
    }

    public int countByStatus(Todo.TodoStatus status) {
        return repository.countByStatus(status);
    }

    public List<Todo> searchByStatus(Todo.TodoStatus status) {
        return repository.findAllByStatus(status);
    }

    public List<Todo> upcoming() {
//        return repository.upcoming();
        return repository.findTop3ByStatusIsNotOrderByDueDate(Todo.TodoStatus.COMPLETED);
    }
}
