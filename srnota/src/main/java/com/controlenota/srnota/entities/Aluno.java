package com.controlenota.srnota.entities;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_aluno;

	private String nome;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	private String cpf;

	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
	private Matricula matriculaDoAluno;

	@ManyToOne
    @JoinColumn(name = "id_responsavel", referencedColumnName = "id_responsavel")
	private Responsavel responsavel;

	public Aluno(){};

	public Aluno(Integer id_aluno, String nome, Date dataNascimento, String cpf) {
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Matricula getMatriculaDoAlun() {
		return matriculaDoAluno;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	

	

}
