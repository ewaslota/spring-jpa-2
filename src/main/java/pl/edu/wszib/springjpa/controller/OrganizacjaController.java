package pl.edu.wszib.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Organizacja;
import pl.edu.wszib.springjpa.service.OrganizacjaService;

import java.util.List;

@RestController
@RequestMapping("/organizacja")
public class OrganizacjaController {

    private final OrganizacjaService service;

    public OrganizacjaController(OrganizacjaService service) {
        this.service = service;
    }

    @GetMapping
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

    @PutMapping
    public Organizacja update(@RequestBody Organizacja organizacja) {
        return service.update(organizacja);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
