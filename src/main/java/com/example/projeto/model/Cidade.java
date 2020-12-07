package com.example.projeto.model;

import javax.persistence.*;
@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "id_cidade_estado")
	private long idCidadeEstado;
	
	public Cidade() {
		
	}
	
	public Cidade(Long id, String nome, Long idCidadeEstado) {
		this.nome = nome;
		this.idCidadeEstado = idCidadeEstado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getidCidadeEstado() {
		return idCidadeEstado;
	}

	public void setidCidadeEstadoo(long idCidadeEstado) {
		this.idCidadeEstado = idCidadeEstado;
	}
	
	
	
}
