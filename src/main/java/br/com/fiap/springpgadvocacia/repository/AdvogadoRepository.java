package br.com.fiap.springpgadvocacia.repository;


import br.com.fiap.springpgadvocacia.entity.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvogadoRepository extends JpaRepository<Advogado, Long> {
}
