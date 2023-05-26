/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.politecnicomalaga.TrabajoTallerServidor;
/*
- Tendremos las siguientes "Call" o llamadas API Rest a nuestro HttpServlet:
   --- listaPacientes?parametro=apellidos
   --- listaTratamientos?parametro=dniPaciente
   --- insertPaciente?parametro=jsonPaciente
   --- insertTratamiento?parametro=jsonTratamiento
   --- cobraTratamiento?parametro=codTratamiento;codPaciente

listaPacientes recibirá un string en apellidos un String que buscaremos mediante
like '%apellidos%' en el campo apellidos de Pacientes, en la BBDD.
Los métodos listaLoQueSea devolverán o HTML bien formado en forma de tabla o json que
tendrá que ser trabajado en el cliente correspondiente. Los insert y cobra... devolverán un "OK:
función realizada" o un "error: descripción del error", que podrá ser trabajada en los clientes
de manera adecuada.
 */



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andres
 */
public class Pacientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String peticionSolicitada = request.getParameter("peticion");
        String datos = request.getParameter("datos");  //Datos enviados en CSV
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        
        String resultado = "";
        BDAdaptador bd = new BDAdaptador();
        
        switch (peticionSolicitada) {
            case "todos": resultado = bd.getPacientes();
                 break;
            case "insertar": resultado = bd.insertPaciente(datos);
                 break;
            default: resultado = "<p>Parámetro desconocido</p>";
        }
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //out.print(resultado);
            out.println("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                            "<title>Get Pacientes Result</title>\n" +
                            "<meta charset=\"UTF-8\">\n" +
                            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "</head>\n" +
                        "<body style=\"background-color:red;\"><p>Resultado:</p>\n" +
                            resultado +
                        "</body>\n" +
                        "</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BDAdaptador bd = new BDAdaptador();
        String jsonRespuesta = bd.getPacientesPorApellidos();

        response.setContentType("application/json");

        response.getWriter().write(jsonRespuesta);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "BackEnd TrabajoTaller Servlet";
    }// </editor-fold>

}