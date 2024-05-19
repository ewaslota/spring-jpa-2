package pl.edu.wszib.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Todo;
import pl.edu.wszib.springjpa.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/upcoming/list")
    public List<Todo> upcoming() {
        return service.upcoming();
    }

    @GetMapping("/search/{status}")
    public List<Todo> searchByStatus(@PathVariable Todo.TodoStatus status) {
        return service.searchByStatus(status);
    }

    @GetMapping("/count/{status}")
    public int countByStatus(@PathVariable Todo.TodoStatus status) {
        return service.countByStatus(status);
    }

    @GetMapping
    public List<Todo> list(@RequestParam(required = false, defaultValue = "asc") String order) {
        return service.list(order);
    }

    @GetMapping("/{id}")
    public Todo get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.create(todo);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) {
        return service.update(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
