package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.Advogado;
import br.com.fiap.springpgadvocacia.entity.Processo;
import br.com.fiap.springpgadvocacia.entity.TipoDeAcao;
import br.com.fiap.springpgadvocacia.repository.AdvogadoRepository;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import br.com.fiap.springpgadvocacia.repository.ProcessoRepository;
import br.com.fiap.springpgadvocacia.repository.TipoDeAcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/processo")
public class ProcessoResource {

    @Autowired
    private ProcessoRepository repo;

    @Autowired
    private AdvogadoRepository repoAdvogado;

    @Autowired
    private TipoDeAcaoRepository repoTipo;

    @GetMapping
    public List<Processo> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Processo findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Processo save(@RequestBody Processo processo) {

        if (Objects.nonNull(processo.getAdvogado().getId())) {
            Advogado advogado = repoAdvogado.findById(processo.getAdvogado().getId()).orElseThrow();
            processo.setAdvogado(advogado);
        }

        if (Objects.nonNull(processo.getTipoDeAcao().getId())) {
            TipoDeAcao tipo = repoTipo.findById(processo.getTipoDeAcao().getId()).orElseThrow();
            processo.setTipoDeAcao(tipo);
        }

        return repo.save(processo);
    }

}
