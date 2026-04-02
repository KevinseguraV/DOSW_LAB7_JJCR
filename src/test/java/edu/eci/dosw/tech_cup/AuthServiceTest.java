package edu.eci.dosw.tech_cup;

import edu.eci.dosw.tech_cup.service.AuthService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private final AuthService authService = new AuthService();

    @Test
    void testCredencialesCorrectas() {
        assertTrue(authService.autenticar("admin@techcup.com", "admin123"));
    }

    @Test
    void testCredencialesIncorrectas() {
        assertFalse(authService.autenticar("falso@test.com", "wrongpass"));
    }

    @Test
    void testContrasenaIncorrecta() {
        assertFalse(authService.autenticar("admin@techcup.com", "incorrecta"));
    }
}