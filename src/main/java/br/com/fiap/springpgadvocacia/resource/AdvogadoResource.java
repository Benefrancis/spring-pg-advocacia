package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.Advogado;
import br.com.fiap.springpgadvocacia.repository.AdvogadoRepository;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<Advogado>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Advogado> findById(@PathVariable Long id) {

        //Buscando o Advogado com o Id informado na requisição
        var advogado = repo.findById(id);

        //Se não encontrou o Advogado com o id informado eu retorno o erro 404 - Not found
        if (advogado.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(advogado.get());

    }

    @Transactional
    @PostMapping
    public ResponseEntity<Advogado> save(@RequestBody Advogado advogado) {

        //Informaram o Id do Estado?
        if (Objects.nonNull(advogado.getEstado().getId())) {

            //Buscando o Estado com o Id informado na requisição
            var estado = repoEstado.findById(advogado.getEstado().getId());

            //Se não encontrou o estado com o id informado então foi uma requisição maliciosa
            if (estado.isEmpty()) return ResponseEntity.badRequest().build();

            advogado.setEstado(estado.get());
        }

        Advogado save = repo.save(advogado);

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
