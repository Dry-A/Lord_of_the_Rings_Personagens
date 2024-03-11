package org.audrey.lord_of_the_rings.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsuarioDTOTest {
    @Test
    public void testConstrutorComParametros() {
        // Arrange
        String nomeEsperado = "Frodo";
        String usuarioEsperado = "frodo123";

        // Act
        UsuarioDTO usuarioDTO = new UsuarioDTO(nomeEsperado, usuarioEsperado);

        // Assert
        assertEquals(nomeEsperado, usuarioDTO.getNome());
        assertEquals(usuarioEsperado, usuarioDTO.getUsuario());
    }

    @Test
    public void testConstrutorPadrao() {
        // Arrange
        // Nenhum dado específico para este teste, pois o construtor padrão não define valores.

        // Act
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        // Assert
        assertEquals(null, usuarioDTO.getNome());
        assertEquals(null, usuarioDTO.getUsuario());
    }

}



