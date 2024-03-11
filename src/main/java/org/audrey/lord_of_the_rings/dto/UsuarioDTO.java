package org.audrey.lord_of_the_rings.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private String nome;
    private String usuario;

    public UsuarioDTO() {}

    public UsuarioDTO(String nome, String usuario) {

        this.nome = nome;
        this.usuario = usuario;

    }

}
