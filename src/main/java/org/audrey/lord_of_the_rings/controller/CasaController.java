package org.audrey.lord_of_the_rings.controller;

import jakarta.validation.Valid;
import org.audrey.lord_of_the_rings.model.Casa;
import org.audrey.lord_of_the_rings.repository.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/casas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CasaController {

        @Autowired
        private CasaRepository objetoCasaRepository;

        @GetMapping
        public ResponseEntity <List<Casa>> getAll(){
            return ResponseEntity.ok(objetoCasaRepository.findAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Casa> getById(@PathVariable Long id){
                return objetoCasaRepository.findById(id)
                        .map(resposta -> ResponseEntity.ok(resposta))
                        .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

        @GetMapping("/descricao/{descricao}")
        public ResponseEntity <List<Casa>> getByDescricao(@PathVariable String descricao){
                return ResponseEntity.ok(objetoCasaRepository
                        .findAllByDescricaoContainingIgnoreCase(descricao));
    }

        @PostMapping
        public ResponseEntity<Casa> post(@Valid @RequestBody Casa casa){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(objetoCasaRepository.save(casa));
        }

        @PutMapping
        public ResponseEntity<Casa> put(@Valid @RequestBody Casa casa){
            return objetoCasaRepository.findById(casa.getId())
                    .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                            .body(objetoCasaRepository.save(casa)))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        }

        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            Optional<Casa> casa = objetoCasaRepository.findById(id);

            if(casa.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            objetoCasaRepository.deleteById(id);
        }
}

