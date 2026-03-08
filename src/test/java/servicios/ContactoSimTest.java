package servicios;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;

public class ContactoSimTest {

    private InterfazContactoSim contactoSim;

    @BeforeEach
    void setUp() {
        // Trabajamos con la interfaz, luego podremos cambiar la instancia al mock 
        contactoSim = new ContactoSim();
    }

    @Test
    void testGetEntities() {
        List<Entidad> entities = contactoSim.getEntities();
        assertNotNull(entities);
        assertTrue(entities.size() > 0);
    }

    @Test
    void testSolicitarSimulation() {
        DatosSolicitud ds = new DatosSolicitud(new HashMap<>());
        int token = contactoSim.solicitarSimulation(ds);
        assertTrue(token > 0);
    }

    @Test
    void testDescargarDatos() {
        DatosSimulation ds = contactoSim.descargarDatos(999);
        assertNotNull(ds);
    }

    @Test
    void testIsValidEntityId() {
        assertTrue(contactoSim.isValidEntityId());
    }
}
