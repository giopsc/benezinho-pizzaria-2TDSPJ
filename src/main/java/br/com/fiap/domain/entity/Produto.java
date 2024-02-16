package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(
            name = "SQ_PRODUTO",
            sequenceName = "SQ_PRODUTO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO")
    private String nome;

    @Column(name = "VL_PRODUTO")
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(
            name = "SABOR_ID",
            referencedColumnName = "ID_SABOR",
            foreignKey = @ForeignKey(name = "FK_SABOR_PRODUTO")
    )
    private Sabor sabor;


    public Produto() {
    }

    public Produto(Long id, String nome, BigDecimal preco, Sabor sabor) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.sabor = sabor;
    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public Produto setSabor(Sabor sabor) {
        this.sabor = sabor;
        return this;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", sabor=" + sabor +
                '}';
    }
}
