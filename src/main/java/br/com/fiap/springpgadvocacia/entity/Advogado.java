package br.com.fiap.springpgadvocacia.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPG_ADVOGADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Advogado {

    @Id
    @Column(name = "ID_ADVOGADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ADVOGADO")
    @SequenceGenerator(name = "SQ_ADVOGADO", sequenceName = "SQ_ADVOGADO", allocationSize = 1)
    private Long id;

    private String nome;

    private String numeroOAB;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ESTADO", referencedColumnName = "ID_ESTADO", foreignKey = @ForeignKey(name = "FK_ESTADO_ADVOGADO"))
    private Estado estado;

}
