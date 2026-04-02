package edu.eci.dosw.tech_cup;

import edu.eci.dosw.tech_cup.entity.EstadoTorneo;
import edu.eci.dosw.tech_cup.entity.Torneo;
import edu.eci.dosw.tech_cup.service.TorneoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TorneoServiceTest {

    private TorneoService torneoService;

    @BeforeEach
    void setUp() {
        torneoService = new TorneoService();
    }

    @Test
    void testCrearTorneoConEstadoBorradorPorDefecto() {
        Torneo t = new Torneo();
        t.setNombre("Copa Test");
        t.setFechaInicio(LocalDate.now());
        t.setFechaFin(LocalDate.now().plusMonths(1));

        Torneo creado = torneoService.create(t);

        assertEquals(EstadoTorneo.BORRADOR, creado.getEstado());
    }

    @Test
    void testNoModificarTorneoFinalizado() {
        Torneo t = torneoService.findAll().get(0);
        t.setEstado(EstadoTorneo.FINALIZADO);
        torneoService.update(t.getId(), t); // lo ponemos en FINALIZADO

        Torneo cambio = new Torneo();
        cambio.setNombre("Intento modificar");

        Optional<Torneo> resultado = torneoService.update(t.getId(), cambio);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void testEliminarTorneoEnBorrador() {
        Torneo t = new Torneo();
        t.setNombre("Torneo a eliminar");
        Torneo creado = torneoService.create(t);

        boolean eliminado = torneoService.delete(creado.getId());

        assertTrue(eliminado);
    }

    @Test
    void testNoEliminarTorneoEnCurso() {
        Torneo t = torneoService.findAll().get(0);
        t.setEstado(EstadoTorneo.EN_CURSO);

        boolean eliminado = torneoService.delete(t.getId());

        assertFalse(eliminado);
    }
}