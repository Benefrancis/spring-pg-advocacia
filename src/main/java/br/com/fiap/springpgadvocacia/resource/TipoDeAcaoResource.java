package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.TipoDeAcao;
import br.com.fiap.springpgadvocacia.repository.TipoDeAcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tipo-de-acao")
public class TipoDeAcaoResource {

    @Autowired
    private TipoDeAcaoRepository repo;

    @GetMapping
    public List<TipoDeAcao> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public TipoDeAcao findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public TipoDeAcao save(@RequestBody TipoDeAcao tipo) {
        return repo.save(tipo);
    }

}
