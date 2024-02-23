package br.com.fiap.domain.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_OPCIONAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Opcional {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPCIONAL")
    @SequenceGenerator(
            name = "SQ_OPCIONAL", sequenceName = "SQ_OPCIONAL"
    )
    @Column(name = "ID_OPCIONAL")
    private Long id;

    @Column(name = "NM_OPCIONAL")
    private String nome;

    @Column(name = "PRECO")
    private Double preco;

}
