package edu.eci.dosw.tech_cup.service;

import edu.eci.dosw.tech_cup.entity.EstadoTorneo;
import edu.eci.dosw.tech_cup.entity.Torneo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TorneoService {

    private final List<Torneo> torneos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TorneoService() {
        torneos.add(new Torneo(
                idGenerator.getAndIncrement(),
                "Torneo Demo",
                LocalDate.now(),
                LocalDate.now().plusMonths(1),
                8,
                EstadoTorneo.BORRADOR
        ));
    }

    public List<Torneo> findAll() {
        return new ArrayList<>(torneos);
    }

    public Optional<Torneo> findById(Long id) {
        return torneos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Torneo create(Torneo torneo) {
        torneo.setId(idGenerator.getAndIncrement());
        torneo.setEstado(EstadoTorneo.BORRADOR);
        torneos.add(torneo);
        return torneo;
    }

    public Optional<Torneo> update(Long id, Torneo torneo) {
        for (int i = 0; i < torneos.size(); i++) {
            if (torneos.get(i).getId().equals(id)) {
                if (EstadoTorneo.FINALIZADO.equals(torneos.get(i).getEstado())) {
                    return Optional.empty();
                }
                torneo.setId(id);
                torneos.set(i, torneo);
                return Optional.of(torneo);
            }
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        return torneos.removeIf(t ->
                t.getId().equals(id) &&
                        EstadoTorneo.BORRADOR.equals(t.getEstado())
        );
    }
}