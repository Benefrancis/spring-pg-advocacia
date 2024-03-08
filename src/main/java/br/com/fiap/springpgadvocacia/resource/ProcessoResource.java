package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.Processo;
import br.com.fiap.springpgadvocacia.repository.AdvogadoRepository;
import br.com.fiap.springpgadvocacia.repository.ProcessoRepository;
import br.com.fiap.springpgadvocacia.repository.TipoDeAcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<Processo>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Processo> findById(@PathVariable Long id) {

        //Buscando o Processo com o Id informado na requisição
        var processo = repo.findById(id);

        //Se não encontrou o Processo com o id informado eu retorno o erro 404 - Not found
        if (processo.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(processo.get());
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Processo> save(@RequestBody Processo processo) {

        if (Objects.nonNull(processo.getAdvogado().getId())) {

            //Buscando o Advogado com o Id informado na requisição
            var advogado = repoAdvogado.findById(processo.getAdvogado().getId());

            //Se não encontrou o advogado com o id informado então foi uma requisição maliciosa
            if (advogado.isEmpty()) return ResponseEntity.badRequest().build();

            processo.setAdvogado(advogado.get());
        }

        if (Objects.nonNull(processo.getTipoDeAcao().getId())) {
            //Buscando o Tipo com o Id informado na requisição
            var tipo = repoTipo.findById(processo.getTipoDeAcao().getId());

            //Se não encontrou o Tipo com o id informado então foi uma requisição maliciosa
            if (tipo.isEmpty()) return ResponseEntity.badRequest().build();

            processo.setTipoDeAcao(tipo.get());
        }

        Processo save = repo.save(processo);

        //Sempre que salvar um novo elemento deve-se retornar o código 201 - Created
        //Este retorno deve sempre conter a URI para se chegar ao recurso salvo
        //O endereço para o recurso ficará no cabeçalho da resposta com a chave Location e o value
        //igual ao endereço do recurso
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getId())
                .toUri();

        return ResponseEntity.created(uri).body(save);
    }

}
