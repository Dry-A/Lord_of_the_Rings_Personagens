package org.audrey.lord_of_the_rings.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tb_casas")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descriçao da Casa é obrigatória")
    @Size(min = 03, max = 30, message = " Mínimo de 03 e máximo de 30 caracteres")
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "casa", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("casa")
    private List<Personagens> personagem;

}
