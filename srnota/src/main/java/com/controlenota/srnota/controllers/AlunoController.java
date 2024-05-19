package com.controlenota.srnota.controllers;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.controlenota.srnota.dto.AlunoDTO;
import com.controlenota.srnota.services.AlunoService;

@RestController // Controlado implementa um recurso na APITest
// Para configurar a classe pra que ela responda pela rota /Aluno usa essa anotação - COnfigura  o controlador para responder por esta URL
@RequestMapping(value = "/aluno") // Mapeia todas as requisições para o caminho /api // Configuraçaõ da rota
public class AlunoController {

    @Autowired
    private AlunoService service; // Injeção de dependência - Injeção de dependência de um serviço de aluno

    @GetMapping(value = "/{id}") // Anotação essencial para que este recurso rsponda pelo método HTTP GET     
    public ResponseEntity<AlunoDTO> findById(@PathVariable Long id){
        AlunoDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<AlunoDTO>> findAll(Pageable pageable){
        Page<AlunoDTO> dto = service.findAll(pageable);
    	return ResponseEntity.ok(dto);
    }  

    @PostMapping
    public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto){
    	dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                  .buildAndExpand(dto.getId_aluno()).toUri();
        return ResponseEntity.created(uri).body(dto);        
    }  

    @PutMapping(value = "/{id}") // Anotação essencial para que este recurso rsponda pelo método HTTP GET 
    
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id_aluno, @RequestBody AlunoDTO dto){
        dto = service.update(id_aluno, dto);
        return ResponseEntity.ok(dto);
    }

    
    @DeleteMapping(value = "/{id}") // Anotação essencial para que este recurso rsponda pelo método HTTP GET 
    
    public ResponseEntity<Void> delete(@PathVariable Long id_aluno){
        service.delete(id_aluno);
        return ResponseEntity.noContent().build();
    }
}
