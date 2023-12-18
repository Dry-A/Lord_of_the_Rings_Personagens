package org.audrey.lord_of_the_rings.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_personagens")
public class Personagens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório!")
    @Size(min = 3, max = 50, message = "Nome deve conter no mínimo 6 e no máximo 100 caracteres.")
    private String nome;
    @NotBlank(message = "Casa é obrigatório!")
    @Size(min = 3, max = 20, message = "O campo casa deve conter no mínimo 20 e no máximo 100 caracteres.")
    private String casa;
    @NotNull
    private int forca;
    @NotBlank
    private String arma;
    @NotBlank
    private String poder;

}
