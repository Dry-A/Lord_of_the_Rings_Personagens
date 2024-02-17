package org.audrey.lord_of_the_rings.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLogin {

    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private String foto;
    private String token;
}
