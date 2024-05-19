package com.controlenota.srnota.dto;

import java.util.Date;

import com.controlenota.srnota.entities.Aluno;

public class AlunoDTO {

    private Integer id_aluno;

	private String nome;

	private Date dataNascimento;

	private String cpf;

    public AlunoDTO(Aluno entity){
        id_aluno = entity.getId_aluno();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        cpf = entity.getCpf();
        }

    public AlunoDTO(Integer id_aluno, String nome, Date dataNascimento, String cpf) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integer getId_aluno() {
        return id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
    
    

}
