package com.example.projeto.model;


import javax.persistence.*;

@Entity
@Table(name = "estado")
public class Estado {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "id_estado")
	private long idEstado;
	
	public Estado() {
		
	}	
	
	public Estado(Long id, String nome, Long idEstado) {
		this.nome = nome;
		this.idEstado = idEstado;
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

	public long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	
}
