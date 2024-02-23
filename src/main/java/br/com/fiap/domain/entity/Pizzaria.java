package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PIZZARIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizzaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PIZZARIA")
    @SequenceGenerator(name = "SQ_PIZZARIA")
    @Column(name = "ID_PIZZARIA")
    private Long id;

    @Column(name = "NM_PIZZARIA")
    private String nome;


}
