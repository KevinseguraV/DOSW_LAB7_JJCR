package edu.eci.dosw.tech_cup;

import edu.eci.dosw.tech_cup.entity.Usuario;
import edu.eci.dosw.tech_cup.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {

    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioService();
    }

    @Test
    void testCrearUsuarioConRolJugadorPorDefecto() {
        Usuario u = new Usuario();
        u.setNombre("Carlos");
        u.setCorreo("carlos@test.com");
        u.setContrasena("pass123");

        Usuario creado = usuarioService.create(u);

        assertEquals("JUGADOR", creado.getRol());
    }

    @Test
    void testCrearUsuarioActivoPorDefecto() {
        Usuario u = new Usuario();
        u.setNombre("María");
        u.setCorreo("maria@test.com");

        Usuario creado = usuarioService.create(u);

        assertTrue(creado.isActivo());
    }

    @Test
    void testInactivarUsuarioEnVezDeEliminar() {
        Usuario creado = usuarioService.create(
                new Usuario(null, "Pedro", "pedro@test.com", "123", "JUGADOR", true)
        );

        usuarioService.deactivate(creado.getIdUsuario());

        assertFalse(usuarioService.findById(creado.getIdUsuario()).get().isActivo());
    }

    @Test
    void testListarUsuarios() {
        assertFalse(usuarioService.findAll().isEmpty());
    }
}