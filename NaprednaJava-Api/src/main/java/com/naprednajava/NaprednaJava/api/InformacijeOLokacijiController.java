package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.InformacijeOLokaciji;
import com.naprednajava.NaprednaJava.services.InformacijeOLokaciji.IInformacijeOLokacijiService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/informacijeOLokaciji")
@RestController
public class InformacijeOLokacijiController {

    private final IInformacijeOLokacijiService iInformacijeOLokacijiService;

    @Autowired
    public InformacijeOLokacijiController(@Qualifier("informacijeOLokacijiService") IInformacijeOLokacijiService iInformacijeOLokacijiService) {
        this.iInformacijeOLokacijiService = iInformacijeOLokacijiService;
    }

    @GetMapping
    public List<InformacijeOLokaciji> getAll() {
        return iInformacijeOLokacijiService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<InformacijeOLokaciji> getById(@PathVariable("id") Integer id) {

        var informacijeOLokaciji = iInformacijeOLokacijiService.getById(id).orElse(null);

        if (informacijeOLokaciji == null)
            return new ServiceResult<>(false, "Informacije o lokaciji nisu pronadjene", informacijeOLokaciji);

        return new ServiceResult<>(true, "", informacijeOLokaciji);
    }

    @PostMapping
    public ServiceResult<InformacijeOLokaciji> insert(@Valid @NotNull @RequestBody InformacijeOLokaciji informacijeOLokaciji) {
        return iInformacijeOLokacijiService.insert(informacijeOLokaciji);
    }

    @PutMapping(path = "{id}")
    public ServiceResult<InformacijeOLokaciji> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody InformacijeOLokaciji informacijeOLokaciji) {

        var iol = iInformacijeOLokacijiService.getById(id).orElse(null);

        if (iol == null)
            return new ServiceResult<>(false, "Informacije o lokaciji nisu pronadjene", iol);

        return iInformacijeOLokacijiService.update(id, informacijeOLokaciji);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<InformacijeOLokaciji> delete(@PathVariable("id") Integer id) {

        var informacijeOLokaciji = iInformacijeOLokacijiService.getById(id).orElse(null);

        if (informacijeOLokaciji == null)
            return new ServiceResult<>(false, "Informacije o lokaciji nisu pronadjene", informacijeOLokaciji);

        return iInformacijeOLokacijiService.delete(informacijeOLokaciji);
    }
}
