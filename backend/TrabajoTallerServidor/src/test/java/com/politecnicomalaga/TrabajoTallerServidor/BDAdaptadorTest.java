import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class BDAdaptadorTest {

    @Test
    public void testGetPacientes() {
        BDAdaptador bd = new BDAdaptador();
        String pacientes = bd.getPacientes();
        assertNotNull(pacientes);
        assertTrue(pacientes.contains("1;Juan;García;654123456;juan.garcia@gmail.com;12345678A;01/01/1990"));
        assertTrue(pacientes.contains("2;María;González;654987654;maria.gonzalez@gmail.com;98765432B;02/02/1995"));
        assertTrue(pacientes.contains("3;Pedro;Rodríguez;654555555;pedro.rodriguez@gmail.com;55555555C;03/03/1985"));
    }

    @Test
    public void testInsertPaciente() {
        BDAdaptador bd = new BDAdaptador();
        String resultado = bd.insertPaciente("4;Ana;García;654111111;ana.garcia@gmail.com;11111111D;04/04/1990");
        assertEquals("<p>Paciente insertado correctamente</p>", resultado);
        resultado = bd.insertPaciente("4;Ana;García;654111111;ana.garcia@gmail.com;11111111D;04/04/1990");
        assertEquals("<p>Error al insertar</p>", resultado);
    }

    @Test
    public void testGetPacientesPorApellidos() {
        BDAdaptador bd = new BDAdaptador();
        String pacientes = bd.getPacientesPorApellidos();
        assertNotNull(pacientes);
        assertTrue(pacientes.contains("2;María;González;654987654;maria.gonzalez@gmail.com;98765432B;02/02/1995"));
        assertTrue(pacientes.contains("1;Juan;García;654123456;juan.garcia@gmail.com;12345678A;01/01/1990"));
        assertTrue(pacientes.contains("3;Pedro;Rodríguez;654555555;pedro.rodriguez@gmail.com;55555555C;03/03/1985"));
    }

}
