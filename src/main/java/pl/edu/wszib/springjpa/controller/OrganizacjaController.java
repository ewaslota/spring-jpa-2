package pl.edu.wszib.springjpa.controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Organizacja;
import pl.edu.wszib.springjpa.service.OrganizacjaService;
import java.util.List;
@RestController
@RequestMapping("/organizacja")
public class OrganizacjaController {
    private OrganizacjaService service;
    public List<Organizacja> list() {
        return service.list();
    }
    @GetMapping("/{id}")
    public Organizacja get(@PathVariable Long id) {
        return service.get(id);
    }
    @PostMapping
    public Organizacja create(@RequestBody Organizacja organizacja) {
        return service.create(organizacja);
    }
    @PutMapping("/{id}")
    public Organizacja update(@PathVariable Long id, @RequestBody Organizacja organizacja) {
        organizacja.setId(id);
        return service.update(organizacja);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
