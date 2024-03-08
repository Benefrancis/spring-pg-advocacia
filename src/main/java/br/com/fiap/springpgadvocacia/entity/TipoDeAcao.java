package br.com.fiap.springpgadvocacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPG_TIPO_ACAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDeAcao {

    @Id
    @Column(name = "ID_TIPO_ACAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_ACAO")
    @SequenceGenerator(name = "SQ_TIPO_ACAO", sequenceName = "SQ_TIPO_ACAO", allocationSize = 1)
    private Long id;
    
    private String nome;
}
