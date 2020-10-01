package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.Prostorija;
import com.naprednajava.NaprednaJava.services.Prostorija.IProstorijaService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/prostorije")
@RestController
public class ProstorijaController {

    private final IProstorijaService prostorijaService;

    @Autowired
    public ProstorijaController(@Qualifier("prostorijaService") IProstorijaService prostorijaService) {
        this.prostorijaService = prostorijaService;
    }

    @GetMapping
    public List<Prostorija> getAll() {
        return prostorijaService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<Prostorija> getById(@PathVariable("id") Integer id) {

        var prostorija = prostorijaService.getById(id).orElse(null);

        if (prostorija == null)
            return new ServiceResult<>(false, "Prostorija nije pronadjena", prostorija);

        return new ServiceResult<>(true, "", prostorija);
    }

    @PostMapping
    public ServiceResult<Prostorija> insert(@Valid @NotNull @RequestBody Prostorija prostorija) {
        return prostorijaService.insert(prostorija);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<Prostorija> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody Prostorija prostorija) {

        var p = prostorijaService.getById(id).orElse(null);

        if (p == null)
            return new ServiceResult<>(false, "Prostorija nije pronadjena", p);

        return prostorijaService.update(id, prostorija);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<Prostorija> delete(@PathVariable("id") Integer id) {

        var prostorija = prostorijaService.getById(id).orElse(null);

        if (prostorija == null)
            return new ServiceResult<>(false, "Prostorija nije pronadjena", prostorija);

        return prostorijaService.delete(prostorija);
    }
}
