package com.controlenota.srnota.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_disciplina;

	private String nome;

	@ManyToOne
    @JoinColumn(name = "turma_id")
	private Turma turmaDisciplina;

	public Disciplina(){}

	public Disciplina(Integer id_disciplina, String nome) {
		this.id_disciplina = id_disciplina;
		this.nome = nome;
	}

	public Integer getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Integer id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurmaDisciplina() {
		return turmaDisciplina;
	}

	

}
