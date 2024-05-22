package com.controlenota.srnota.services;

import java.util.Optional;

import org.slf4j.Logger;


import org.springframework.transaction.annotation.Propagation;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controlenota.srnota.dto.AlunoDTO;
import com.controlenota.srnota.repositories.AlunoRepository;
import com.controlenota.srnota.services.exceptions.*;

import jakarta.persistence.EntityNotFoundException;

import com.controlenota.srnota.entities.Aluno;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    
    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id_aluno){
        Optional<Aluno> result = repository.findById(id_aluno); // o findById por padrão retorna o objeto Optional, por isso tem que estanciar o Optionla <Classe de>
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
    public AlunoDTO update (Long id_aluno, AlunoDTO dto){
        try{

            Aluno entity = repository.getReferenceById(id_aluno); // essa referencia nao vai ate o banco de dados, ele so prepara o objeto monitorado pelo JPA       
            copyDtoTOEntity(dto, entity);
            entity = repository.save(entity);
            return new AlunoDTO(entity);

        }
               catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recursno não encontrado");
        }
       
    }
    
   @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id_aluno) {
        Logger logger = LoggerFactory.getLogger(getClass());
        
        if (!repository.existsById(id_aluno)) {
            logger.warn("Tentativa de deletar recurso não encontrado com ID: {}", id_aluno);
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        
        try {
            repository.deleteById(id_aluno);
            logger.info("Recurso com ID: {} deletado com sucesso", id_aluno);
        } catch (DataIntegrityViolationException e) {
            logger.error("Falha de integridade referencial ao deletar recurso com ID: {}", id_aluno, e);
            throw new DatabaseException("Falha de integridade referencial");
        }
}

    private void copyDtoTOEntity(AlunoDTO dto, Aluno entity) {
        entity.setNome(dto.getNome());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCpf(dto.getCpf());
    }
       


}
