package edu.eci.dosw.tech_cup.controller;

import edu.eci.dosw.tech_cup.dto.LoginRequest;
import edu.eci.dosw.tech_cup.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // POST login — compara correo y contraseña
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        boolean autenticado = authService.autenticar(
                request.getCorreo(),
                request.getContrasena()
        );
        if (autenticado) {
            return ResponseEntity.ok("Autenticación exitosa");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Correo o contraseña incorrectos");
    }
}