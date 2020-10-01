package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.VrstaPovrsine;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import com.naprednajava.NaprednaJava.services.VrstaPovrsine.IVrstaPovrsineService;
import com.naprednajava.NaprednaJava.services.VrstaPovrsine.VrstaPovrsineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/vrstePovrsina")
@RestController
public class VrstaPovrsineController {

    private final IVrstaPovrsineService vrstaPovrsineService;

    @Autowired
    public VrstaPovrsineController(@Qualifier("vrstaPovrsineService") VrstaPovrsineService vrstaPovrsineService) {
        this.vrstaPovrsineService = vrstaPovrsineService;
    }

    @GetMapping
    public List<VrstaPovrsine> getAll() {
        return vrstaPovrsineService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<VrstaPovrsine> getById(@PathVariable("id") Integer id) {

        var vrstaPovrsine = vrstaPovrsineService.getById(id).orElse(null);

        if (vrstaPovrsine == null)
            return new ServiceResult<>(false, "Vrsta povrsine nije pronadjena", vrstaPovrsine);

        return new ServiceResult<>(true, "", vrstaPovrsine);
    }

    @PostMapping
    public ServiceResult<VrstaPovrsine> insert(@Valid @NotNull @RequestBody VrstaPovrsine vrstaPovrsine) {
        return vrstaPovrsineService.insert(vrstaPovrsine);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<VrstaPovrsine> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody VrstaPovrsine vrstaPovrsine) {

        var vp = vrstaPovrsineService.getById(id).orElse(null);

        if (vp == null)
            return new ServiceResult<>(false, "Vrsta povrsine nije pronadjena", vp);

        return vrstaPovrsineService.update(id, vrstaPovrsine);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<VrstaPovrsine> delete(@PathVariable("id") Integer id) {

        var vrstaPovrsine = vrstaPovrsineService.getById(id).orElse(null);

        if (vrstaPovrsine == null)
            return new ServiceResult<>(false, "Vrsta povrsine nije pronadjena", vrstaPovrsine);

        return vrstaPovrsineService.delete(vrstaPovrsine);
    }
}
