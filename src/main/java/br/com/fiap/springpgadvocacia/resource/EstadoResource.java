package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.Estado;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import br.com.fiap.springpgadvocacia.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {

    @Autowired
    private EstadoRepository repo;

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Long id) {

        //Buscando o Advogado com o Id informado na requisição
        var estado = repo.findById(id);

        //Se não encontrou o Advogado com o id informado eu retorno o erro 404 - Not found
        if (estado.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(estado.get());
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody Estado estado) {

        Estado save = repo.save(estado);

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
