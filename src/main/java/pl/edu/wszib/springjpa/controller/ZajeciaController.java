package pl.edu.wszib.springjpa.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.springjpa.model.Prowadzacy;
import pl.edu.wszib.springjpa.model.Zajecia;
import pl.edu.wszib.springjpa.service.ZajeciaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zajecia")
public class ZajeciaController {

    private final ZajeciaService service;

    public ZajeciaController(ZajeciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ListZajeciaDTO> list(
            @RequestParam(required = false) String nazwa,
            @RequestParam(required = false) Long studentId
    ) {
        List<Zajecia> zajecias = nazwa != null && studentId != null ?
                service.list(nazwa, studentId) : service.list();
        List<ListZajeciaDTO> out = new ArrayList<>();
        for (Zajecia z : zajecias) {
            out.add(ListZajeciaDTO.fromZajecia(z));
        }
        return out;
    }

    @GetMapping("/{id}")
    public Zajecia get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}/dodajStudenta/{idStudenta}")
    public Zajecia dodaj(@PathVariable Long id, @PathVariable Long idStudenta) {
        return service.dodajStudenta(id, idStudenta);
    }

    @PutMapping("/{id}/usunStudenta/{idStudenta}")
    public Zajecia usun(@PathVariable Long id, @PathVariable Long idStudenta) {
        return service.usunStudenta(id, idStudenta);
    }

    @PostMapping
    public Zajecia create(@RequestBody CreateZajeciaDTO createZajeciaDTO) {
        return service.create(createZajeciaDTO.getNazwa(), createZajeciaDTO.getProwadzacyId());
    }
}

class CreateZajeciaDTO {
    private String nazwa;

    private Long prowadzacyId;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Long getProwadzacyId() {
        return prowadzacyId;
    }

    public void setProwadzacyId(Long prowadzacyId) {
        this.prowadzacyId = prowadzacyId;
    }
}

class ListZajeciaDTO {
    private Long id;
    private String nazwa;
    private Prowadzacy prowadzacy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Prowadzacy getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(Prowadzacy prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public static ListZajeciaDTO fromZajecia(Zajecia zajecia) {
        ListZajeciaDTO out = new ListZajeciaDTO();
        out.setId(zajecia.getId());
        out.setNazwa(zajecia.getNazwa());
        out.setProwadzacy(zajecia.getProwadzacy());
        return out;
    }
}