package br.edu.fatec.gru.historia_brinquedo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_brinquedo")
public class BrinquedoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;
    private String marca;
    private Double valor;
    private String descricao;

    // Construtores
    public BrinquedoEntity() {}

    public BrinquedoEntity(String nome, String categoria, String marca, Double valor, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.marca = marca;
        this.valor = valor;
        this.descricao = descricao;
    }

    // Getters e Setters
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
