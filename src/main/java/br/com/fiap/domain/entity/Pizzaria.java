package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_CARDAPIO",
            joinColumns = {
                    @JoinColumn(
                            name = "PIZZARIA",
                            referencedColumnName = "ID_PIZZARIA",
                            foreignKey = @ForeignKey(name = "FK_PIZZARIA_CARDAPIO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_CARDAPIO_PIZZARIA")
                    )
            }
    )
    private Set<Produto> cardapio = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public Pizzaria setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pizzaria setNome(String nome) {
        this.nome = nome;
        return this;
    }


    @Override
    public String toString() {
        return "Pizzaria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
