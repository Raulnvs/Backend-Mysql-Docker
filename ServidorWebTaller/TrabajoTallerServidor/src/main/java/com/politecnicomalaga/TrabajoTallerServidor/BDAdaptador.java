/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politecnicomalaga.TrabajoTallerServidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author andres
 */
public class BDAdaptador {

    private String sLastError;
    
    public BDAdaptador() {
        sLastError = "";
    }
 
    private Connection initDatabase()            
    {
            Connection con = null;
            // Initialize all the information regarding
            // Database Connection
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql://bbdd:3306/";
            // Database name to access
            String dbName = "taller_db";
            String dbUsername = "mecanico";
            String dbPassword = "2secret2know";

            try {
                Class.forName(dbDriver);
                con = DriverManager.getConnection(dbURL + dbName, dbUsername,dbPassword);
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error conectando a la BBDD: " + e.getMessage()+ "</p>";
                e.printStackTrace();
            }
            return con;
    }
    
    
    
    public String getPacientes() {
        String resultado = "";
        String id, nombre, apellidos, telefono, email, dni, sFNac;
        Connection con = null;
        Statement st = null;
        PreparedStatement ps = null;
        int iRows = 0;
        try {
            con = this.initDatabase();

            //st = con.createStatement();
            ps = con.prepareStatement("select * from pacientes");


            
            //ResultSet rs = st.executeQuery("select * from pacientes");
            ResultSet rs = ps.executeQuery();
            
             // iteración sobre el resultset
            while (rs.next())  //Mientras tengamos rows de salida...
            {
              iRows++;
              id = (rs.getString("id"));
              nombre = rs.getString("nombre");
              apellidos = rs.getString("apellidos");
              telefono = rs.getString("telefono");
              email = rs.getString("email");
              dni = rs.getString("dni");
              sFNac = rs.getString("sFNac");
              
              // save the results
              resultado += "<p>" + id + ";" +
                      nombre + ";" +
                      apellidos + ";" +
                      telefono + ";" +
                      email + ";" +
                      dni + ";" +
                      sFNac + "</p>\n";
            }
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la BBDD Select: " + e.getMessage()+ "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos sentencia y conexión
            try {
                if (st!= null) st.close();
                if (con!=null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la BBDD: " + e.getMessage()+ "</p>";
                e.printStackTrace();
                     
            }
        }
        resultado += "\n<p>Rows recogidas: " + iRows + "</p>\n";
        if (sLastError.isEmpty()) return resultado;        
        else return resultado + sLastError;
    }
    
    
    //Método de inserción en la tabla de pacientes de un nuevo valor.
    public String insertPacientes(String sCSV) {
        String resultado = "<p>Error al insertar</p>";
        String id, nombre, apellidos, telefono, email, dni, sFNac;
        Connection con = null;
       
        Paciente miPc = new Paciente(sCSV);
        
        PreparedStatement ps = null;
      
        try {
            con = this.initDatabase();

            //st = con.createStatement();
            ps = con.prepareStatement("insert into pacientes (id,nombre,apellidos,telefono,email,dni,sFNac) values (?,?,?,?,?,?,?)");
            ps.setString(1, String.valueOf((int)(Math.random()*100000)));
            ps.setString(2, miPc.getsNombre());
            ps.setString(3,miPc.getsApellidos());
            ps.setString(4,miPc.getsTelefono());
            ps.setString(5,miPc.getsEmail());
            ps.setString(6,miPc.getsDni());
            ps.setString(7,miPc.getsFNac());

            
            
            if (ps.executeUpdate()!=0)
                 resultado = "<p>Paciente insertado correctamente</p>";
            else resultado = "<p>Algo ha salido mal con la sentencia Insert Pacientes</p>";
            //En este caso es una orden hacia la BBDD, y no tenemos
            //ResultSet para iterar, las cosas pueden ir bien, o mal, nada más
            //que hacer entonces aquí
            
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la BBDD Select: " + e.getMessage()+ "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos sentencia y conexión
            try {
                if (ps!= null) ps.close();
                if (con!=null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la BBDD: " + e.getMessage()+ "</p>";
                e.printStackTrace();
                     
            }
        }
        if (sLastError.isEmpty()) return resultado;        
        else return resultado + sLastError;
        
    }
    
}

