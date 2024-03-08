package br.com.fiap.springpgadvocacia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPG_PROCESSO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Processo {

    @Id
    @Column(name = "ID_PROCESSO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO")
    @SequenceGenerator(name = "SQ_PROCESSO", sequenceName = "SQ_PROCESSO", allocationSize = 1)
    private Long id;

    private String numero;

    private Boolean proBono;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ADVOGADO", referencedColumnName = "ID_ADVOGADO", foreignKey = @ForeignKey(name = "FK_ADVOGADO_PROCESSO"))
    private Advogado advogado;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "TIPO", referencedColumnName = "ID_TIPO_ACAO", foreignKey = @ForeignKey(name = "FK_TIPO_ACAO_PROCESSO"))
    private TipoDeAcao tipoDeAcao;

}
