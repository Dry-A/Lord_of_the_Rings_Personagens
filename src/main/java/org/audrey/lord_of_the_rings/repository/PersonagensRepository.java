package org.audrey.lord_of_the_rings.repository;


import org.audrey.lord_of_the_rings.model.Personagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagensRepository extends JpaRepository<Personagens, Long> {

}