package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.Estado;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {

    @Autowired
    private EstadoRepository repo;

    @GetMapping
    public List<Estado> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Estado findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Estado save(@RequestBody Estado estado) {
        return repo.save(estado);
    }

}
