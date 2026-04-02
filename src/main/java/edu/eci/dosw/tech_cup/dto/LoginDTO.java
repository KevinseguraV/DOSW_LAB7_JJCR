package edu.eci.dosw.tech_cup.dto;

public class LoginDTO {
    private String correo;
    private String password;

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return password; }
    public void setContrasena(String contrasena) { this.password = contrasena; }
}