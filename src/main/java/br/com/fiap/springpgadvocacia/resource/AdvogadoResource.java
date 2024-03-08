package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.Advogado;
import br.com.fiap.springpgadvocacia.repository.AdvogadoRepository;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/advogado")
public class AdvogadoResource {

    @Autowired
    private AdvogadoRepository repo;

    @Autowired
    private EstadoRepository repoEstado;

    @GetMapping
    public List<Advogado> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Advogado findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Advogado save(@RequestBody Advogado advogado) {

        if(Objects.nonNull(advogado.getEstado().getId())){
            var estado = repoEstado.findById(advogado.getEstado().getId()).orElseThrow();
            advogado.setEstado(estado);
        }

        return repo.save(advogado);
    }

}
