package edu.eci.dosw.tech_cup.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {


    public boolean autenticar(String correo, String contrasena) {
        return "admin@escuelaing.edu.co".equals(correo) && "admin123".equals(contrasena);
    }
}