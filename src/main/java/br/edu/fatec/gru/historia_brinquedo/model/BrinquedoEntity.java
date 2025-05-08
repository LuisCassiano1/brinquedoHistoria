package br.edu.fatec.gru.historia_brinquedo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_brinquedo")
public class BrinquedoEntity {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		 @Column(name = "nome_produto", nullable = false, length = 100)
		    private String nomeProduto;
		 
		 @Column(name = "categoria_produto", nullable = false, length = 100)
		    private String categoriaProduto;
		 
		 @Column(name = "marca_produto", nullable = false, length = 100)
		    private String marcaProduto;
		 
		 @Column(name = "url_imagem", length = 255)
		    private String urlImagem;
		 
		 @Column(name = "valor_produto", nullable = false)
		    private Double valorProduto;
		 
		 @Column(name = "descricao_produto")
		    @Lob // Para campos TEXT no banco de dados
		    private String descricaoProduto;
		
		public BrinquedoEntity() {
			
		}
		
		public BrinquedoEntity(String nomeProduto, String categoriaProduto, String marcaProduto, String urlImagem, Double valorProduto, String descricaoProduto) {
	        this.nomeProduto = nomeProduto;
	        this.categoriaProduto = categoriaProduto;
	        this.marcaProduto = marcaProduto;
	        this.urlImagem = urlImagem;
	        this.valorProduto = valorProduto;
	        this.descricaoProduto = descricaoProduto;    
	    }

		public Long getId() {
	        return id;
	    }
		public void setId(Long id) {
	        this.id = id;
	    }
		public String getNomeProduto() {
			return nomeProduto;
		}
		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}

		public String getCategoriaProduto() {
			return categoriaProduto;
		}

		public void setCategoriaProduto(String categoriaProduto) {
			this.categoriaProduto = categoriaProduto;
		}

		public String getMarcaProduto() {
			return marcaProduto;
		}

		public void setMarcaProduto(String marcaProduto) {
			this.marcaProduto = marcaProduto;
		}

		public String getUrlImagem() {
			return urlImagem;
		}

		public void setUrlImagem(String urlImagem) {
			this.urlImagem = urlImagem;
		}

		public Double getValorProduto() {
			return valorProduto;
		}
		
		//@Positive(message "favor colocar um numero positivo")
		public void setValorProduto(Double valorProduto) {
			this.valorProduto = valorProduto;
		}

		public String getDescricaoProduto() {
			return descricaoProduto;
		}

		public void setDescricaoProduto(String descricaoProduto) {
			this.descricaoProduto = descricaoProduto;
		}
		
		 @Override
		    public String toString() {
		        return "Brinquedo{" +
		                "id=" + id +
		                ", nomeProduto='" + nomeProduto + '\'' +
		                ", categoriaProduto='" + categoriaProduto + '\'' +
		                ", marcaProduto='" + marcaProduto + '\'' +
		                ", urlImagem=" + urlImagem +
		                ", valorProduto=" + valorProduto +
		                ", descricaoProduto='" + descricaoProduto + '\'' +
		                '}';
		    }
		
}