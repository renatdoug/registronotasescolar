package com.controlenota.srnota.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_curso;

	private String nome;

	private Integer ano;
    
	@OneToOne
	@JoinColumn(name = "escola_id")
	private Escola escola;

	@OneToMany(mappedBy = "curso")
	private List<Turma> turmasDoCurso = new ArrayList<>();

	public Curso(){};

	public Curso(Integer id_curso, String nome, Integer ano) {
		this.id_curso = id_curso;
		this.nome = nome;
		this.ano = ano;
		
	};

	public Integer getId_curso() {
		return id_curso;
	}

	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Escola getEscola() {
		return escola;
	}

	public List<Turma> getTurmasDoCurso() {
		return turmasDoCurso;
	}
	

}
