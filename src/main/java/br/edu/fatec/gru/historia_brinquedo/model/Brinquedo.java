package br.edu.fatec.gru.historia_brinquedo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Brinquedos")
public class Brinquedo {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String nome;
		private String marca;
		private float preco;
		
		public Brinquedo() {
			
		}
		
		public Brinquedo(String nome, int id, String marca, float preco) {
			this.nome = nome;
			this.id = id;
			this.marca = marca;
			this.preco = preco;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}

		public float getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}
		
		public String getImagemUrl() {
			return imagemUrl;
		}

		public void setImagemUrl(String imagemUrl) {
			this.imagemUrl = imagemUrl;
		}
		
		
}