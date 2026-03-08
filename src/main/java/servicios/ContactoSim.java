package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;

@Service
public class ContactoSim implements InterfazContactoSim {

    private final List<Entidad> entities;
    private final Map<Integer, DatosSolicitud> solicitudes;
    private final Random random;

    public ContactoSim() {
        this.entities = new ArrayList<>();
        this.solicitudes = new HashMap<>();
        this.random = new Random();
        inicializarEntidades();
    }

    private void inicializarEntidades() {
        Entidad e1 = new Entidad();
        e1.setId(1);
        e1.setName("Sensores de Temperatura");
        e1.setDescripcion("Controlan la temperatura ambiental.");
        entities.add(e1);

        Entidad e2 = new Entidad();
        e2.setId(2);
        e2.setName("Medidores de Humedad");
        e2.setDescripcion("Miden el nivel de humedad en el aire.");
        entities.add(e2);

        Entidad e3 = new Entidad();
        e3.setId(3);
        e3.setName("Cámaras de Seguridad");
        e3.setDescripcion("Sistemas de vigilancia por video.");
        entities.add(e3);
    }

    @Override
    public int solicitarSimulation(DatosSolicitud sol) {
        int token = 1000 + random.nextInt(9000);
        solicitudes.put(token, sol);
        return token;
    }

    @Override
    public DatosSimulation descargarDatos(int ticket) {
        return new DatosSimulation();
    }

    @Override
    public List<Entidad> getEntities() {
        return entities;
    }

    @Override
    public boolean isValidEntityId() {
        return true;
    }
}
