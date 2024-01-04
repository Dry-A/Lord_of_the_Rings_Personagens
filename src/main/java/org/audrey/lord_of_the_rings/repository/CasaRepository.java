package org.audrey.lord_of_the_rings.repository;


import org.audrey.lord_of_the_rings.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CasaRepository extends JpaRepository<Casa, Long> {

    public List<Casa> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);

}
