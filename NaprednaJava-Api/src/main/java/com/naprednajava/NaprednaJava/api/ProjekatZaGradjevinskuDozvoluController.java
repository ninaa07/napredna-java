package com.naprednajava.NaprednaJava.api;


import com.naprednajava.NaprednaJava.models.Enums.Status;
import com.naprednajava.NaprednaJava.models.Povrsina;
import com.naprednajava.NaprednaJava.models.ProjekatZaGradjevinskuDozvolu;
import com.naprednajava.NaprednaJava.services.Povrsina.IPovrsinaService;
import com.naprednajava.NaprednaJava.services.Povrsina.PovrsinaService;
import com.naprednajava.NaprednaJava.services.ProjekatZaGradjevinskuDozvolu.IProjekatZaGradjevinskuDozvoluService;
import com.naprednajava.NaprednaJava.services.ProjekatZaGradjevinskuDozvolu.ProjekatZaGradjevinskuDozvoluService;
import com.naprednajava.NaprednaJava.services.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Console;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/projektiZaGradjevinskuDozvolu")
@RestController
public class ProjekatZaGradjevinskuDozvoluController {

    private final IProjekatZaGradjevinskuDozvoluService projekatZaGradjevinskuDozvoluService;
    private final IPovrsinaService povrsinaService;

    @Autowired
    public ProjekatZaGradjevinskuDozvoluController(@Qualifier("projekatZaGradjevinskuDozvoluService") ProjekatZaGradjevinskuDozvoluService projekatZaGradjevinskuDozvoluService, @Qualifier("povrsinaService") PovrsinaService povrsinaService) {
        this.projekatZaGradjevinskuDozvoluService = projekatZaGradjevinskuDozvoluService;
        this.povrsinaService = povrsinaService;
    }

    @GetMapping
    public List<ProjekatZaGradjevinskuDozvolu> getAll() {
        return projekatZaGradjevinskuDozvoluService.getAll();
    }

    @GetMapping(path = "{id}")
    public ServiceResult<ProjekatZaGradjevinskuDozvolu> getById(@PathVariable("id") Integer id) {

        var projekatZaGradjevinskuDozvolu = projekatZaGradjevinskuDozvoluService.getById(id).orElse(null);

        if (projekatZaGradjevinskuDozvolu == null)
            return new ServiceResult<>(false, "Projekat za gradjevinsku dozvolu nije pronadjen", projekatZaGradjevinskuDozvolu);

        return new ServiceResult<>(true, "", projekatZaGradjevinskuDozvolu);
    }

    @PostMapping
    public ServiceResult<ProjekatZaGradjevinskuDozvolu> insert(@Valid @NotNull @RequestBody ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {

        projekatZaGradjevinskuDozvolu.setDatumIzrade(new Date());

        var result = projekatZaGradjevinskuDozvoluService.insert(projekatZaGradjevinskuDozvolu);

        var size = projekatZaGradjevinskuDozvolu.getPovrsine().size();

        for (int i = 0; i < size; i++) {
            var povrsina = projekatZaGradjevinskuDozvolu.getPovrsine().get(i);
            povrsina.setProjekatZaGradjevinskuDozvoluId(result.resultObject.getId());
            result.resultObject.getPovrsine().add(povrsina);
            povrsinaService.insert(povrsina);
        }

        return result;
    }

    @PutMapping(path = "{id}")
    public ServiceResult<ProjekatZaGradjevinskuDozvolu> update(@PathVariable("id") Integer id, @Valid @NotNull @RequestBody ProjekatZaGradjevinskuDozvolu projekatZaGradjevinskuDozvolu) {

        var pgd = projekatZaGradjevinskuDozvoluService.getById(id).orElse(null);

        if (pgd == null)
            return new ServiceResult<>(false, "Projekat za gradjevinsku dozvolu nije pronadjen", pgd);

        projekatZaGradjevinskuDozvolu.setDatumIzrade(new Date());

        for (Povrsina p : projekatZaGradjevinskuDozvolu.getPovrsine()) {
            if (p.getStatus().equals(Status.None))
                continue;
            else if (p.getStatus().equals(Status.Insert)) {
                p.setProjekatZaGradjevinskuDozvoluId(projekatZaGradjevinskuDozvolu.getId());
                povrsinaService.insert(p);
            } else if (p.getStatus().equals(Status.Update))
                povrsinaService.update(p.getId(), p);
            else
                povrsinaService.delete(p);
        }

        return projekatZaGradjevinskuDozvoluService.update(projekatZaGradjevinskuDozvolu.getId(), projekatZaGradjevinskuDozvolu);
    }

    @DeleteMapping(path = "{id}")
    public ServiceResult<ProjekatZaGradjevinskuDozvolu> delete(@PathVariable("id") Integer id) {

        var projekatZaGradjevinskuDozvolu = projekatZaGradjevinskuDozvoluService.getById(id).orElse(null);

        if (projekatZaGradjevinskuDozvolu == null)
            return new ServiceResult<>(false, "Projekat za gradjevinsku dozvolu nije pronadjen", projekatZaGradjevinskuDozvolu);

        return projekatZaGradjevinskuDozvoluService.delete(projekatZaGradjevinskuDozvolu);
    }
}
