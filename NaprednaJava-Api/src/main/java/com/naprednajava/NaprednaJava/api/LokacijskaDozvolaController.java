package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.LokacijskaDozvola;
import com.naprednajava.NaprednaJava.services.LokacijskaDozvola.ILokacijskaDozvolaService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import view_models.LokacijskaDozvola.AddLokacijskaDozvolaDto;
import view_models.LokacijskaDozvola.LokacijskaDozvolaDto;
import view_models.LokacijskaDozvola.UpdateLokacijskaDozvolaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/lokacijskeDozvole")
@RestController
public class LokacijskaDozvolaController {

    private final ILokacijskaDozvolaService lokacijskaDozvolaService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public LokacijskaDozvolaController(@Qualifier("lokacijskaDozvolaService") ILokacijskaDozvolaService lokacijskaDozvolaService) {
        this.lokacijskaDozvolaService = lokacijskaDozvolaService;
    }

    @GetMapping
    public List<LokacijskaDozvola> getAll() {
        return lokacijskaDozvolaService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<LokacijskaDozvola> getById(@PathVariable("id") Integer id) {

        var lokacijskaDozvola = lokacijskaDozvolaService.getById(id).orElse(null);

        if (lokacijskaDozvola == null)
            return new ServiceResult<>(false, "Lokacijska dozvola nije pronadjena", lokacijskaDozvola);

        return new ServiceResult<>(true, "", lokacijskaDozvola);
    }

    @PostMapping
    public ServiceResult<LokacijskaDozvola> insert(@Valid @NotNull @RequestBody LokacijskaDozvola lokacijskaDozvola) {

        lokacijskaDozvola.setDatumIzdavanja(new Date());

        return lokacijskaDozvolaService.insert(lokacijskaDozvola);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<LokacijskaDozvola> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody LokacijskaDozvola lokacijskaDozvola) {

        var ld = lokacijskaDozvolaService.getById(id).orElse(null);

        if (ld == null)
            return new ServiceResult<>(false, "Lokacijska dozvola nije pronadjena", ld);

        lokacijskaDozvola.setDatumIzdavanja(new Date());

        return lokacijskaDozvolaService.update(id, lokacijskaDozvola);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<LokacijskaDozvola> delete(@PathVariable("id") Integer id) {

        var lokacijskaDozvola = lokacijskaDozvolaService.getById(id).orElse(null);

        if (lokacijskaDozvola == null)
            return new ServiceResult<>(false, "Lokacijska dozvola nije pronadjena", lokacijskaDozvola);

        return lokacijskaDozvolaService.delete(lokacijskaDozvola);
    }
}
