package com.controlenota.srnota.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_matricula")
public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_matricula;

	private String matricula;

	@ManyToOne
    @JoinColumn(name =  "turma_id")
	private Turma turmaMatricula;

	@OneToMany(mappedBy = "matricula")   
	private List<Nota> notasDaMatricula = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public Matricula(){};
	

	public Matricula(Integer id_matricula, String matricula) {
		this.id_matricula = id_matricula;
		this.matricula = matricula;
	}

	public Integer getId_matricula() {
		return id_matricula;
	}

	public void setId_matricula(Integer id_matricula) {;
		this.id_matricula = id_matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Turma getTurmaMatricula() {
		return turmaMatricula;
	}

	public List<Nota> getNotasDaMatricula() {
		return notasDaMatricula;
	}

	public Aluno getAluno() {
		return aluno;
	}

}
