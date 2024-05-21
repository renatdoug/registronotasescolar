package com.controlenota.srnota.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlenota.srnota.dto.AlunoDTO;
import com.controlenota.srnota.repositories.AlunoRepository;
import com.controlenota.srnota.services.exceptions.ResourceNotFoundException;


import com.controlenota.srnota.entities.Aluno;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    
    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id){
        Optional<Aluno> result = repository.findById(id); // o findById por padrão retorna o objeto Optional, por isso tem que estanciar o Optionla <Classe de>
        Aluno aluno = result.orElseThrow(
            ()-> new ResourceNotFoundException("Recursno não encontrado"));
        return new AlunoDTO(aluno);                

    }

    @Transactional(readOnly = true)
    public Page<AlunoDTO> findAll(Pageable pageable){
        Page<Aluno> result = repository.findAll(pageable);
        return result.map(AlunoDTO:: new);
    }

     @Transactional
    public AlunoDTO insert(AlunoDTO dto){
        Aluno entity = new Aluno();
        copyDtoTOEntity(dto, entity);
        entity = repository.save(entity);
        return new AlunoDTO(entity);
    }  

    @Transactional
    public AlunoDTO update (Long id, AlunoDTO dto){
        Aluno entity = repository.getReferenceById(id);        
        copyDtoTOEntity(dto, entity);
        return new AlunoDTO(entity);
    }
    
    @Transactional()
    public void delete(Long id){
        repository.deleteById(id);
    }

    private void copyDtoTOEntity(AlunoDTO dto, Aluno entity) {
        entity.setId_aluno(dto.getId_aluno());
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCpf(dto.getCpf());
    }
       


}
