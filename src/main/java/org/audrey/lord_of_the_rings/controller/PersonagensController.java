package org.audrey.lord_of_the_rings.controller;

import jakarta.validation.Valid;
import org.audrey.lord_of_the_rings.model.Personagens;
import org.audrey.lord_of_the_rings.repository.PersonagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonagensController {

    @Autowired
    private PersonagensRepository personagensRepository;

    @GetMapping
    public ResponseEntity<List<Personagens>> getAll(){
        return ResponseEntity.ok(personagensRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagens> getById(@PathVariable Long id) {
        return  personagensRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List <Personagens> > getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(personagensRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/arma/{arma}")
    public ResponseEntity<List <Personagens>> getByArma(@PathVariable String arma) {
        return ResponseEntity.ok(personagensRepository.findAllByArmaContainingIgnoreCase(arma));
    }

    @GetMapping("casa/{casa}")
    public ResponseEntity<List <Personagens>> getByCasa(@PathVariable String casa){
        return  ResponseEntity.ok(personagensRepository.findAllByCasaContainingIgnoreCase(casa));
    }

    @PostMapping
    public ResponseEntity <Personagens> post(@Valid @RequestBody Personagens meuPersonagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personagensRepository.save(meuPersonagem));
    }

    @PutMapping
    public ResponseEntity<Personagens> put(@Valid @RequestBody Personagens meuPersonagem) {
        return personagensRepository.findById(meuPersonagem.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.OK)
                        .body(personagensRepository.save(meuPersonagem)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}