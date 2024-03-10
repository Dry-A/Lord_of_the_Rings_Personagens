package org.audrey.lord_of_the_rings.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import org.audrey.lord_of_the_rings.dto.UsuarioDTO;

@Getter
@Setter
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo nome deve ser preenchido!")
    private String nome;

    @NotNull(message = "O atributo Usuario deve ser preenchido! Use um email ou nickname")
    private String usuario;

    @NotNull(message = "Você deve criar uma senha!")
    private String senha;

    @Size(max = 5000, message = "O link da foto nao pode ser maior que 5000 caracteres")
    private String foto;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Personagens> personagem;

    public static UsuarioDTO fromUsuario(Usuario usuario){
        
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setUsuario(usuario.getUsuario());

        return usuarioDTO;

    }
}
