package br.edu.fatec.gru.historia_brinquedo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_brinquedo")
public class BrinquedoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrinquedo;

    private String codigoBrinquedo;
    private String nomeBrinquedo;
    private String categoriaBrinquedo;
    private String marcaBrinquedo;
    private Double valorBrinquedo;
    private String descricaoBrinquedo;
    private String imagemBrinquedo;

    // Construtores
    public BrinquedoEntity() {}

    public BrinquedoEntity(String codigoBrinquedo, String nomeBrinquedo, String categoriaBrinquedo, String marcaBrinquedo, Double valorBrinquedo, String descricaoBrinquedo, String imagemBrinquedo) {
        this.codigoBrinquedo = codigoBrinquedo;
    	this.nomeBrinquedo = nomeBrinquedo;
        this.categoriaBrinquedo = categoriaBrinquedo;
        this.marcaBrinquedo = marcaBrinquedo;
        this.valorBrinquedo = valorBrinquedo;
        this.descricaoBrinquedo = descricaoBrinquedo;
        this.imagemBrinquedo = imagemBrinquedo;
    }

    // Getters e Setters
    
    public Long getIdBrinquedo() {
        return idBrinquedo;
    }

    public void setIdBrinquedo(Long idBrinquedo) {
        this.idBrinquedo = idBrinquedo;
    }
    
    public String getCodigoBrinquedo() {
        return codigoBrinquedo;
    }

    public void setCodigoBrinquedo(String codigoBrinquedo) {
        this.codigoBrinquedo = codigoBrinquedo;
    }
    
    public String getNomeBrinquedo() {
        return nomeBrinquedo;
    }

    public void setNomeBrinquedo(String nomeBrinquedo) {
        this.nomeBrinquedo = nomeBrinquedo;
    }

    public String getCategoriaBrinquedo() {
        return categoriaBrinquedo;
    }

    public void setCategoriaBrinquedo(String categoriaBrinquedo) {
        this.categoriaBrinquedo = categoriaBrinquedo;
    }

    public String getMarcaBrinquedo() {
        return marcaBrinquedo;
    }

    public void setMarcaBrinquedo(String marcaBrinquedo) {
        this.marcaBrinquedo = marcaBrinquedo;
    }

    public Double getValorBrinquedo() {
        return valorBrinquedo;
    }

    public void setValorBrinquedo(Double valorBrinquedo) {
        this.valorBrinquedo = valorBrinquedo;
    }

    public String getDescricaoBrinquedo() {
        return descricaoBrinquedo;
    }

    public void setDescricaoBrinquedo(String descricaoBrinquedo) {
        this.descricaoBrinquedo = descricaoBrinquedo;
    }
    
    public String getImagemBrinquedo() {
        return imagemBrinquedo;
    }

    public void setImagemBrinquedo(String imagemBrinquedo) {
        this.imagemBrinquedo = imagemBrinquedo;
    }
}
