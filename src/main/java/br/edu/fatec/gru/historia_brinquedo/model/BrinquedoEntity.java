package br.edu.fatec.gru.historia_brinquedo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Brinquedos")
public class BrinquedoEntity {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String nome;
		private String categoria;
		private String marca;
		private float preco;
		
		public BrinquedoEntity() {
			
		}
		
		public BrinquedoEntity(String nome, int id, String categoria, String marca, float preco) {
			this.nome = nome;
			this.id = id;
			this.categoria = categoria;
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

		public float getPreco() {
			return preco;
		}

		public void setPreco(float preco) {
			this.preco = preco;
		}
		
}