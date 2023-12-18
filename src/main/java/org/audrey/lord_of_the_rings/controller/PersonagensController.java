package org.audrey.lord_of_the_rings.controller;

import org.audrey.lord_of_the_rings.model.Personagens;
import org.audrey.lord_of_the_rings.repository.PersonagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}