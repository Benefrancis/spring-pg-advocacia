package br.com.fiap.springpgadvocacia.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPG_ESTADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estado {


    @Id
    @Column(name = "ID_ESTADO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO")
    @SequenceGenerator(name = "SQ_ESTADO", sequenceName = "SQ_ESTADO", allocationSize = 1)
    private Long id;

    private String nome;

    private String sigla;


}
