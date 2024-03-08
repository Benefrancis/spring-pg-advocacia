package br.com.fiap.springpgadvocacia.resource;

import br.com.fiap.springpgadvocacia.entity.TipoDeAcao;
import br.com.fiap.springpgadvocacia.repository.TipoDeAcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tipo-de-acao")
public class TipoDeAcaoResource {

    @Autowired
    private TipoDeAcaoRepository repo;

    @GetMapping
    public ResponseEntity<List<TipoDeAcao>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoDeAcao> findById(@PathVariable Long id) {

        //Buscando o Tipo com o Id informado na requisição
        var tipoDeAcao = repo.findById(id);

        //Se não encontrou o Advogado com o id informado eu retorno o erro 404 - Not found
        if (tipoDeAcao.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(tipoDeAcao.get());
    }

    @Transactional
    @PostMapping
    public ResponseEntity<TipoDeAcao> save(@RequestBody TipoDeAcao tipo) {

        TipoDeAcao save = repo.save(tipo);

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
