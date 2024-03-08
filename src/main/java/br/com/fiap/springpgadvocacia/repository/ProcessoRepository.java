package br.com.fiap.springpgadvocacia.repository;


import br.com.fiap.springpgadvocacia.entity.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
