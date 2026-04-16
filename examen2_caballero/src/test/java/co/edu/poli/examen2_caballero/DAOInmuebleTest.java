package co.edu.poli.examen2_caballero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_caballero.modelo.*;
import co.edu.poli.examen2_caballero.servicios.*;

public class DAOInmuebleTest {

  @Test
void testDuplicadoFalla() {

    DAOInmueble dao = new DAOInmueble();

    Propietario p = new Propietario(7, "Juan");

    Casa c1 = new Casa("9000", "2024-01-01", "Disponible", p, 2);
    Casa c2 = new Casa("9000", "2024-01-01", "Disponible", p, 3);

    dao.create(c1);
    boolean r2 = dao.create(c2);

    // 🔴 falla a propósito
    assertFalse(r2);
    }
}