package pl.edu.wszib.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Prowadzacy;
import pl.edu.wszib.springjpa.model.Prowadzacy;
import pl.edu.wszib.springjpa.service.ProwadzacyService;
import pl.edu.wszib.springjpa.service.ProwadzacyService;

import java.util.List;

@RestController
@RequestMapping("/prowadzacy")
public class ProwadzacyController {

    private final ProwadzacyService service;

    public ProwadzacyController(ProwadzacyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prowadzacy> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Prowadzacy get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public Prowadzacy create(@RequestBody Prowadzacy prowadzacy) {
        return service.create(prowadzacy);
    }

    @PutMapping
    public Prowadzacy update(@RequestBody Prowadzacy prowadzacy) {
        return service.update(prowadzacy);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
