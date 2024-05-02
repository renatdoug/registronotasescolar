package com.controlenota.srnota.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatricula;

    private String matricula; // Alterado para String para representar o formato desejado

    private Integer anoMatricula;

    @OneToOne(mappedBy = "matricula")
    private Aluno aluno;
    
    public Matricula() {
        // Construtor vazio necessário para JPA
    }

    

    public Matricula(Long idMatricula, String matricula, Integer anoMatricula) {
        this.idMatricula = idMatricula;
        this.anoMatricula = anoMatricula;
        gerarMatricula();

    }


    private void gerarMatricula() {
        // Gerar dois dígitos aleatórios
        int algarismo1 = (int) (Math.random() * 10);
        int algarismo2 = (int) (Math.random() * 10);

        // Formatar a matrícula no padrão desejado
        this.matricula = String.format("%d%02d%d", anoMatricula, algarismo1, algarismo2);
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getAnoMatricula() {
        return anoMatricula;
    }

    public void setAnoMatricula(Integer anoMatricula) {
        this.anoMatricula = anoMatricula;
    }

    
}

