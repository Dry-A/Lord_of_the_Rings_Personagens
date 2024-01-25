package org.audrey.lord_of_the_rings.controller;

import jakarta.validation.Valid;
import org.audrey.lord_of_the_rings.model.Personagens;
import org.audrey.lord_of_the_rings.repository.CasaRepository;
import org.audrey.lord_of_the_rings.repository.PersonagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonagensController {

    @Autowired
    private PersonagensRepository objetoPersonagensRepository;

    @Autowired
    private CasaRepository objetoCasaRepository;

    @GetMapping
    public ResponseEntity<List<Personagens>> getAll(){
        return ResponseEntity.ok(objetoPersonagensRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagens> getById(@PathVariable Long id) {
        return  objetoPersonagensRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List <Personagens> > getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(objetoPersonagensRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @GetMapping("/arma/{arma}")
    public ResponseEntity<List <Personagens>> getByArma(@PathVariable String arma) {
        return ResponseEntity.ok(objetoPersonagensRepository.findAllByArmaContainingIgnoreCase(arma));
    }

    @PostMapping
    public ResponseEntity <Personagens> post(@Valid @RequestBody Personagens meuPersonagem) {
        if(objetoCasaRepository.existsById(meuPersonagem.getCasa().getId()))
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(objetoPersonagensRepository.save(meuPersonagem));

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Casa não existe!", null);
    }

    @PutMapping
    public ResponseEntity<Personagens> put(@Valid @RequestBody Personagens meuPersonagem) {
        if(objetoPersonagensRepository.existsById(meuPersonagem.getId())){

            if(objetoCasaRepository.existsById(meuPersonagem.getCasa().getId()))
                return ResponseEntity.status(HttpStatus.OK)
                        .body(objetoPersonagensRepository.save(meuPersonagem));

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Casa Não Existe!", null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){

        Optional<Personagens> meuPersonagem = objetoPersonagensRepository.findById(id);

        if (meuPersonagem.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            objetoPersonagensRepository.deleteById(id);
    }

}