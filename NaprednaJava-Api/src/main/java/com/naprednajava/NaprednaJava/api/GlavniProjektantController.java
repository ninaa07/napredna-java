package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.GlavniProjektant;
import com.naprednajava.NaprednaJava.services.GlavniProjektant.IGlavniProjektantService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/glavniProjektanti")
@RestController
public class GlavniProjektantController {

    private final IGlavniProjektantService glavniProjektantService;

    @Autowired
    public GlavniProjektantController(@Qualifier("glavniProjektantService") IGlavniProjektantService glavniProjektantService) {
        this.glavniProjektantService = glavniProjektantService;
    }

    @GetMapping
    public List<GlavniProjektant> getAll() {
        return glavniProjektantService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<GlavniProjektant> getById(@PathVariable("id") Integer id) {

        var glavniProjektant = glavniProjektantService.getById(id).orElse(null);

        if (glavniProjektant == null)
            return new ServiceResult<>(false, "Glavni projektant nije pronadjen", glavniProjektant);

        return new ServiceResult<>(true, "", glavniProjektant);
    }

    @PostMapping
    public ServiceResult<GlavniProjektant> insert(@Valid @NotNull @RequestBody GlavniProjektant glavniProjektant) {
        return glavniProjektantService.insert(glavniProjektant);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<GlavniProjektant> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody GlavniProjektant glavniProjektant) {

        var gp = glavniProjektantService.getById(id).orElse(null);

        if (gp == null)
            return new ServiceResult<>(false, "Glavni projektant nije pronadjen", gp);

        return glavniProjektantService.update(id, glavniProjektant);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<GlavniProjektant> delete(@PathVariable("id") Integer id) {

        var glavniProjektant = glavniProjektantService.getById(id).orElse(null);

        if (glavniProjektant == null)
            return new ServiceResult<>(false, "Glavni projektant nije pronadjen", glavniProjektant);

        return glavniProjektantService.delete(glavniProjektant);
    }
}
