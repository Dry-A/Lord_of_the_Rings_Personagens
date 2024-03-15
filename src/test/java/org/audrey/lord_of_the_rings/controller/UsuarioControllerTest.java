package org.audrey.lord_of_the_rings.controller;

import org.audrey.lord_of_the_rings.model.Usuario;
import org.audrey.lord_of_the_rings.repository.UsuarioRepository;
import org.audrey.lord_of_the_rings.service.UsuarioService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

    @Autowired
    private TestRestTemplate meuTestRest;

    @Autowired
    private UsuarioService meuUsuarioService;

    @Autowired
    private UsuarioRepository meuUsuarioRepository;

    @BeforeAll
    void  start(){
        meuUsuarioRepository.deleteAll();
        meuUsuarioService.cadastrarUsuario(new Usuario(0L,"Root", "root@root.com", "rootroot", ""));
    }

    @Test
    @DisplayName("Cadastrar um Usuario")
    public void  deveCriarUmUsuario(){

        HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(new Usuario(0L, "Michael Jackson", "michael@email.com.br", "00223344", "-"));

        ResponseEntity<Usuario> corpoResposta = meuTestRest.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);
        assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());

    }

    @Test
    @DisplayName("Não deve permitir duplicação do Usuário")
    public void naoDeveDuplicarUsuario() {

        meuUsuarioService.cadastrarUsuario(new Usuario(0L,
                "Maria da Silva", "maria_silva@email.com.br", "13465278", "-"));

        HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(new Usuario(0L,
                "Maria da Silva", "maria_silva@email.com.br", "13465278", "-"));

        ResponseEntity<Usuario> corpoResposta = meuTestRest
                .exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);

        assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
    }

    @Test
    @DisplayName("Atualizar um Usuário")
    public void deveAtualizarUmUsuario() {

        Optional<Usuario> usuarioCadastrado = meuUsuarioService.cadastrarUsuario(new Usuario(0L,
                "Megan_errado", "megan_fox@email.com.br", "megan_fox123", "-"));

        Usuario usuarioUpdate = new Usuario(usuarioCadastrado.get().getId(),
                "Megan_foxxy", "megan@email.com.br", "megan123" , "-");

        HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(usuarioUpdate);

        ResponseEntity<Usuario> corpoResposta = meuTestRest
                .withBasicAuth("root@root.com", "rootroot")
                .exchange("/usuarios/atualizar", HttpMethod.PUT, corpoRequisicao, Usuario.class);

        assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());

    }

    @Test
    @DisplayName("Listar todos os Usuários")
    public void deveMostrarTodosUsuarios() {

        meuUsuarioService.cadastrarUsuario(new Usuario(0L,
                "Daryl Dixon", "daryl_dixon@email.com.br", "daryl123", "-"));

        meuUsuarioService.cadastrarUsuario(new Usuario(0L,
                "Ricardo Marques", "gandalf_o_mago@email.com.br", "gandalf123", "-"));

        ResponseEntity<String> resposta = meuTestRest
                .withBasicAuth("root@root.com", "rootroot")
                .exchange("/usuarios/all", HttpMethod.GET, null, String.class);

        assertEquals(HttpStatus.OK, resposta.getStatusCode());

    }

}
