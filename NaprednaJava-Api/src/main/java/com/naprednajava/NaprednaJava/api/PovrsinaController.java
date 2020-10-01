package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.Povrsina;
import com.naprednajava.NaprednaJava.services.Povrsina.IPovrsinaService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/povrsine")
@RestController
public class PovrsinaController {

    private final IPovrsinaService povrsinaService;

    @Autowired
    public PovrsinaController(@Qualifier("povrsinaService") IPovrsinaService povrsinaService) {
        this.povrsinaService = povrsinaService;
    }

    @GetMapping
    public List<Povrsina> getAll() {
        return povrsinaService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<Povrsina> getById(@PathVariable("id") Integer id) {

        var povrsina = povrsinaService.getById(id).orElse(null);

        if (povrsina == null)
            return new ServiceResult<>(false, "Povrsina nije pronadjena", povrsina);

        return new ServiceResult<>(true, "", povrsina);
    }

    @PostMapping
    public ServiceResult<Povrsina> insert(@Valid @NotNull @RequestBody Povrsina povrsina) {
        return povrsinaService.insert(povrsina);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<Povrsina> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody Povrsina povrsina) {

        var p = povrsinaService.getById(id).orElse(null);

        if (p == null)
            return new ServiceResult<>(false, "Povrsina nije pronadjena", p);

        return povrsinaService.update(id, povrsina);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<Povrsina> delete(@PathVariable("id") Integer id) {

        var povrsina = povrsinaService.getById(id).orElse(null);

        if (povrsina == null)
            return new ServiceResult<>(false, "Povrsina nije pronadjena", povrsina);

        return povrsinaService.delete(povrsina);
    }
}
