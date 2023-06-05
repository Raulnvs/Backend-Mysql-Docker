package com.politecnicomalaga.TrabajoTallerServidor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PacienteTest {

    private Paciente paciente;

    @BeforeEach
    public void setUp() {
        paciente = new Paciente("Juan", "Gómez", "123456789", "juan@example.com", "12345678A", "2000-01-01");
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals("Juan", paciente.getsNombre());
        assertEquals("Gómez", paciente.getsApellidos());
        assertEquals("123456789", paciente.getsTelefono());
        assertEquals("juan@example.com", paciente.getsEmail());
        assertEquals("12345678A", paciente.getsDni());
        assertEquals("2000-01-01", paciente.getsFNac());
        assertNull(paciente.todosTratamientos());
    }

    @Test
    public void testNuevoTratamiento() {
        assertTrue(paciente.nuevoTratamiento("T001", "Tratamiento 1", "2021-01-01", 50.0f));
        assertFalse(paciente.nuevoTratamiento("T001", "Tratamiento repetido", "2021-02-01", 75.0f));
        assertTrue(paciente.nuevoTratamiento("T002", "Tratamiento 2", "2021-03-01", 100.0f));

        Tratamiento[] tratamientos = paciente.todosTratamientos();
        assertEquals(2, tratamientos.length);
        assertEquals("T001", tratamientos[0].getsCodigo());
        assertEquals("Tratamiento 1", tratamientos[0].getsDescripcion());
        assertEquals("2021-01-01", tratamientos[0].getsFecha());
        assertEquals(50.0f, tratamientos[0].getfPrecio());

        assertEquals("T002", tratamientos[1].getsCodigo());
        assertEquals("Tratamiento 2", tratamientos[1].getsDescripcion());
        assertEquals("2021-03-01", tratamientos[1].getsFecha());
        assertEquals(100.0f, tratamientos[1].getfPrecio());
    }

    

    @Test
    public void testBuscaTratamientos() {
        paciente.nuevoTratamiento("T001", "Tratamiento 1", "2021-01-01", 50.0f);
        paciente.nuevoTratamiento("T002", "Tratamiento 2", "2021-02-01", 75.0f);
        paciente.nuevoTratamiento("T003", "Tratamiento 3", "2021-03-01", 100.0f);

        Tratamiento[] tratamientos = paciente.buscaTratamientos("Tratamiento", Tratamiento.AtributosTratamiento.DESCRIPCION);
        assertEquals(3, tratamientos.length);

        tratamientos = paciente.buscaTratamientos("T001", Tratamiento.AtributosTratamiento.CODIGO);
        assertEquals(1, tratamientos.length);
        assertEquals("T001", tratamientos[0].getsCodigo());
    }

    @Test
    public void testCobraTratamiento() {
        paciente.nuevoTratamiento("T001", "Tratamiento 1", "2021-01-01", 50.0f);
        paciente.nuevoTratamiento("T002", "Tratamiento 2", "2021-02-01", 75.0f);

        assertEquals(50.0f, paciente.cobraTratamiento("T001")); // Tratamiento cobrado por primera vez
        assertEquals(-1.0f, paciente.cobraTratamiento("T001")); // Tratamiento ya cobrado
        assertEquals(-1.0f, paciente.cobraTratamiento("T003")); // Tratamiento inexistente
    }

    @Test
    public void testTratamientosPendienteCobro() {
        assertFalse(paciente.tratamientosPendienteCobro());

        paciente.nuevoTratamiento("T001", "Tratamiento 1", "2021-01-01", 50.0f);
        assertTrue(paciente.tratamientosPendienteCobro());

        paciente.cobraTratamiento("T001");
        assertFalse(paciente.tratamientosPendienteCobro());
    }

    @Test
    public void testCompara() {
        assertTrue(paciente.compara("Juan", Paciente.AtributosPaciente.NOMBRE));
        assertFalse(paciente.compara("Pedro", Paciente.AtributosPaciente.NOMBRE));

        assertTrue(paciente.compara("Gómez", Paciente.AtributosPaciente.APELLIDOS));
        assertFalse(paciente.compara("López", Paciente.AtributosPaciente.APELLIDOS));

        assertTrue(paciente.compara("12345678A", Paciente.AtributosPaciente.DNI));
        assertFalse(paciente.compara("87654321Z", Paciente.AtributosPaciente.DNI));

        assertTrue(paciente.compara("2000", Paciente.AtributosPaciente.FNAC));
        assertFalse(paciente.compara("1990", Paciente.AtributosPaciente.FNAC));

        assertTrue(paciente.compara("juan@example.com", Paciente.AtributosPaciente.EMAIL));
        assertFalse(paciente.compara("pedro@example.com", Paciente.AtributosPaciente.EMAIL));

        assertTrue(paciente.compara("123456789", Paciente.AtributosPaciente.TFNO));
        assertFalse(paciente.compara("987654321", Paciente.AtributosPaciente.TFNO));
    }

    @Test
    public void testSetValor() {
        paciente.setValor("Pepe", Paciente.AtributosPaciente.NOMBRE);
        assertEquals("Pepe", paciente.getsNombre());

        paciente.setValor("López", Paciente.AtributosPaciente.APELLIDOS);
        assertEquals("López", paciente.getsApellidos());

        paciente.setValor("87654321Z", Paciente.AtributosPaciente.DNI);
        assertEquals("87654321Z", paciente.getsDni());

        paciente.setValor("1990-01-01", Paciente.AtributosPaciente.FNAC);
        assertEquals("1990-01-01", paciente.getsFNac());

        paciente.setValor("pepe@example.com", Paciente.AtributosPaciente.EMAIL);
        assertEquals("pepe@example.com", paciente.getsEmail());

        paciente.setValor("987654321", Paciente.AtributosPaciente.TFNO);
        assertEquals("987654321", paciente.getsTelefono());
    }
}
