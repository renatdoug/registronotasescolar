package com.controlenota.srnota.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.Table;

@Entity
@Table(name = "tb_professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_professor;

	private String nome;

	private String especializacao;

	private String email;

	private String telefone;

	@ManyToMany(mappedBy = "professores")
	private List<Turma> turmasDoProfessores = new ArrayList<>();

	public Professor(){};

	public Professor(Integer id_professor, String nome, String especializacao, String email, String telefone) {
		this.id_professor = id_professor;
		this.nome = nome;
		this.especializacao = especializacao;
		this.email = email;
		this.telefone = telefone;
	}

	public Integer getId_professor() {
		return id_professor;
	}

	public void setId_professor(Integer id_professor) {
		this.id_professor = id_professor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
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

	public List<Turma> getTurmasDoProfessores() {
		return turmasDoProfessores;
	};

	

}
