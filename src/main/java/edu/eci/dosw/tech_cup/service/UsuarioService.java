package edu.eci.dosw.tech_cup.service;

import edu.eci.dosw.tech_cup.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioService {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public UsuarioService() {
        usuarios.add(new Usuario(
                idGenerator.getAndIncrement(),
                "Admin",
                "admin@escuelaing.edu.co",
                "admin123",
                "ADMINISTRADOR",
                true
        ));
    }

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarios.stream()
                .filter(u -> u.getIdUsuario().equals(id))
                .findFirst();
    }

    public Usuario create(Usuario usuario) {
        usuario.setIdUsuario(idGenerator.getAndIncrement());
        usuario.setRol("JUGADOR");   // siempre JUGADOR por defecto
        usuario.setActivo(true);
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> update(Long id, Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario().equals(id)) {
                usuario.setIdUsuario(id);
                usuarios.set(i, usuario);
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }


    public Optional<Usuario> deactivate(Long id) {
        return findById(id).map(u -> {
            u.setActivo(false);
            return u;
        });
    }


    public Optional<Usuario> assignRol(Long id, String nuevoRol) {
        return findById(id).map(u -> {
            u.setRol(nuevoRol);
            return u;
        });
    }
}