package com.controlenota.srnota.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_turma;

	private String nome;

	private Integer ano;

	@ManyToOne
    @JoinColumn(name = "curso_id")
	private Curso curso;

	@ManyToMany
    @JoinTable(
        name = "tb_turma_professor",
        joinColumns = @JoinColumn(name = "turma_id"),
        inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
	private List<Professor> professores = new ArrayList<>();

	@OneToMany(mappedBy = "turmaDisciplina")
	private List<Disciplina> disciplinas = new ArrayList<>();

	@OneToMany(mappedBy = "turmaMatricula")
	private List<Matricula> matriculasDaTurma = new ArrayList<>();

	public Turma(){};

	public Turma(Integer id_turma, String nome, Integer ano) {
		this.id_turma = id_turma;
		this.nome = nome;
		this.ano = ano;
	};

	public Integer getId_turma() {
		;return id_turma;
	}

	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
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

	public Curso getCurso() {
		return curso;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public List<Matricula> getMatriculasDaTurma() {
		return matriculasDaTurma;
	}

	

}
