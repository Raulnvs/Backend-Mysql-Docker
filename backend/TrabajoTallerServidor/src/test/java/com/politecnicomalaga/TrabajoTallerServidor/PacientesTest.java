package com.politecnicomalaga.TrabajoTallerServidor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


//@Adri: He estado investigando sobre como hacer test sobre métodos Servlet y es con una libreria
// que se llama Mockito, aún tengo problemas, pero si lo soluciono lo descomento.

// ############################################################################################################

/*
public class PacientesTest {

    @Mock
    private HttpServletResponse response;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessRequestTodos() throws Exception {
        // Configurar el comportamiento del HttpServletRequest simulado
        when(request.getParameter("peticion")).thenReturn("todos");

        // Configurar el comportamiento del HttpServletResponse simulado
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Crear una instancia de la clase Pacientes
        Pacientes pacientes = new Pacientes();

        // Invocar al método processRequest
        pacientes.processRequest(request, response);

        // Verificar el resultado
        String expectedResponse = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Get Pacientes Result</title>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n" +
                "<body style=\"background-color:red;\"><p>Resultado:</p>\n" +
                "..." +  // Comprobar el contenido esperado
                "</body>\n" +
                "</html>";
        assertEquals(expectedResponse, stringWriter.toString().trim());

        // Verificar que se llamaron los métodos esperados
        verify(request, times(1)).getParameter("peticion");
        verify(response, times(1)).setContentType("text/html;charset=UTF-8");
        verify(response, times(1)).getWriter();
        verify(response, times(1)).setContentType("text/html;charset=UTF-8");
        verify(printWriter, times(1)).println(expectedResponse);
        verify(printWriter, times(1)).close();
    }

    @Test
    public void testDoGetListaPacientes() throws Exception {
        // Configurar el comportamiento del HttpServletRequest simulado
        when(request.getParameter("parametro")).thenReturn("listaPacientes");

        // Configurar el comportamiento del HttpServletResponse simulado
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Crear una instancia de la clase Pacientes
        Pacientes pacientes = new Pacientes();

        // Invocar al método doGet
        pacientes.doGet(request, response);

        // Verificar el resultado
        String expectedResponse = "...";  // Comprobar el contenido esperado
        assertEquals(expectedResponse, stringWriter.toString().trim());

        // Verificar que se llamaron los métodos esperados
        verify(request, times(1)).getParameter("parametro");
        verify(response, times(1)).setContentType(expectedResponse);
        verify(response, times(1)).getWriter();
        verify(response, times(1)).setContentType(expectedResponse);
        verify(printWriter, times(1)).println(expectedResponse);
        verify(printWriter, times(1)).close();
    }

    @Test
    public void testDoGetListaTratamientos() throws Exception {
        // Configurar el comportamiento del HttpServletRequest simulado
        when(request.getParameter("parametro")).thenReturn("listaTratamientos");

        // Configurar el comportamiento del HttpServletResponse simulado
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Crear una instancia de la clase Pacientes
        Pacientes pacientes = new Pacientes();

        // Invocar al método doGet
        pacientes.doGet(request, response);

        // Verificar el resultado
        String expectedResponse = "...";  // Comprobar el contenido esperado
        assertEquals(expectedResponse, stringWriter.toString().trim());

        // Verificar que se llamaron los métodos esperados
        verify(request, times(1)).getParameter("parametro");
        verify(response, times(1)).setContentType(expectedResponse);
        verify(response, times(1)).getWriter();
        verify(response, times(1)).setContentType(expectedResponse);
        verify(printWriter, times(1)).println(expectedResponse);
        verify(printWriter, times(1)).close();
    }

    @Test
    public void testDoGetEndpointInvalido() throws Exception {
        // Configurar el comportamiento del HttpServletRequest simulado
        when(request.getParameter("parametro")).thenReturn("otroValor");

        // Configurar el comportamiento del HttpServletResponse simulado
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Crear una instancia de la clase Pacientes
        Pacientes pacientes = new Pacientes();

        // Invocar al método doGet
        pacientes.doGet(request, response);

        // Verificar el resultado
        String expectedResponse = "Endpoint inválido";
        verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST, expectedResponse);

        // Verificar que no se llamaron otros métodos
        verify(request, never()).getParameter("parametro");
        verify(response, never()).setContentType(anyString());
        verify(response, never()).getWriter();
        verify(printWriter, never()).println(anyString());
        verify(printWriter, never()).close();
    }

    @Test
    public void testDoGetEndpointRequerido() throws Exception {
        // No se configura ningún parámetro en el HttpServletRequest simulado

        // Configurar el comportamiento del HttpServletResponse simulado
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Crear una instancia de la clase Pacientes
        Pacientes pacientes = new Pacientes();

        // Invocar al método doGet
        pacientes.doGet(request, response);

        // Verificar el resultado
        String expectedResponse = "Endpoint requerido";
        verify(response, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST, expectedResponse);

        // Verificar que no se llamaron otros métodos
        verify(request, never()).getParameter("parametro");
        verify(response, never()).setContentType(anyString());
        verify(response, never()).getWriter();
        verify(printWriter, never()).println(anyString());
        verify(printWriter, never()).close();
    }

}
*/