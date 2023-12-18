package org.audrey.lord_of_the_rings.repository;

import org.audrey.lord_of_the_rings.model.Personagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagensRepository extends JpaRepository<Personagens, Long> {

    public List <Personagens> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);

    public List <Personagens> findAllByArmaContainingIgnoreCase(@Param("arma")String arma);

    public List <Personagens> findAllByCasaContainingIgnoreCase(@Param("casa")String casa);

}