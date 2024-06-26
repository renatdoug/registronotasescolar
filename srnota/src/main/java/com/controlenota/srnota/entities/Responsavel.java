package com.controlenota.srnota.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_responsavel")
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_responsavel;

	private String nome;

	private String email;

	private String telefone;

	@OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
	private List<Aluno> alunos = new ArrayList<>();

	public Responsavel(){}

	public Responsavel(Integer id_responsavel, String nome, String email, String telefone) {
		this.id_responsavel = id_responsavel;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	

	public Integer getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(Integer id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}; 


	

}
