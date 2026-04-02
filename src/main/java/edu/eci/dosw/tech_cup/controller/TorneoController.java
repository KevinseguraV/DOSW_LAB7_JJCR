package edu.eci.dosw.tech_cup.controller;

import edu.eci.dosw.tech_cup.entity.Torneo;
import edu.eci.dosw.tech_cup.service.TorneoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/torneos")
public class TorneoController {

    private final TorneoService torneoService;

    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping
    public ResponseEntity<List<Torneo>> getAll() {
        return ResponseEntity.ok(torneoService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Torneo> getById(@PathVariable Long id) {
        return torneoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping
    public ResponseEntity<Torneo> create(@RequestBody Torneo torneo) {
        Torneo creado = torneoService.create(torneo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneo> update(@PathVariable Long id,
                                         @RequestBody Torneo torneo) {
        return torneoService.update(id, torneo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean eliminado = torneoService.delete(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();       // 204
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // 400
    }
}