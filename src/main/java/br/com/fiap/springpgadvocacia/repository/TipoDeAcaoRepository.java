package br.com.fiap.springpgadvocacia.repository;


import br.com.fiap.springpgadvocacia.entity.TipoDeAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeAcaoRepository extends JpaRepository<TipoDeAcao, Long> {
}
