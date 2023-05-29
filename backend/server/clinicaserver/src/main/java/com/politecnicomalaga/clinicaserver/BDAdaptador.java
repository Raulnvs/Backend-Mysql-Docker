package com.politecnicomalaga.clinicaserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

public class BDAdaptador {

    private String sLastError;

    public BDAdaptador() {
        sLastError = "";
    }

    // Inicializamos la conexión con la base de datos
    private Connection initDatabase() {
        // Establecemos la conexión
        Connection con = null;
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://bbdd:3307/";
        // Nombre de la base de datos
        String dbName = "clinica_db";
        String dbUsername = "mecanico";
        String dbPassword = "2secret2know";

        // Establecemos la conexión con la base de datos
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error conectando a la base de datos: " + e.getMessage() + "</p>";
            e.printStackTrace();
        }
        return con;
    }

    // Método para obtener todos los pacientes de la tabla
    public String getPacientes() {
        String resultado = "";
        String id, nombre, apellidos, telefono, email, dni, sFNac;
        Connection con = null;
        Statement st = null;
        PreparedStatement ps = null;
        int iRows = 0;
        try {
            con = this.initDatabase();

            // st = con.createStatement();
            ps = con.prepareStatement("select * from Paciente");

            // ResultSet rs = st.executeQuery("select * from pacientes");
            ResultSet rs = ps.executeQuery();

            // Iteramos sobre el conjunto de resultados (resultset)
            while (rs.next()) {
                iRows++;
                id = (rs.getString("id"));
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                telefono = rs.getString("telefono");
                email = rs.getString("email");
                dni = rs.getString("dni");
                sFNac = rs.getString("sFNac");

                // Guardamos los resultados
                resultado += "<p>" + id + ";" +
                        nombre + ";" +
                        apellidos + ";" +
                        telefono + ";" +
                        email + ";" +
                        dni + ";" +
                        sFNac + "</p>\n";
            }
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la base de datos (SELECT): " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos la sentencia y la conexión
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la base de datos: " + e.getMessage() + "</p>";
                e.printStackTrace();

            }
        }
        resultado += "\n<p>Rows recogidas: " + iRows + "</p>\n";
        if (sLastError.isEmpty()) return resultado;
        else return resultado + sLastError;
    }

    // Método para insertar un nuevo paciente en la tabla
    public String insertPaciente(String sCSV) {
        String resultado = "<p>Error al insertar</p>";
        String id, nombre, apellidos, telefono, email, dni, sFNac; // @Adri: ¿Parece que no utilizamos estas variables?
        Connection con = null;

        Paciente miPc = new Paciente(sCSV);

        PreparedStatement ps = null;

        try {
            con = this.initDatabase();

            // st = con.createStatement();
            ps = con.prepareStatement("insert into Paciente (id,nombre,apellidos,telefono,email,dni,sFNac) values (?,?,?,?,?,?,?)");
            ps.setString(1, String.valueOf((int) (Math.random() * 100000)));
            ps.setString(2, miPc.getsNombre());
            ps.setString(3, miPc.getsApellidos());
            ps.setString(4, miPc.getsTelefono());
            ps.setString(5, miPc.getsEmail());
            ps.setString(6, miPc.getsDni());
            ps.setString(7, miPc.getsFNac());

            if (ps.executeUpdate() != 0)
                resultado = "<p>Paciente insertado correctamente</p>";
            else
                resultado = "<p>Algo ha salido mal con la sentencia Insert Pacientes</p>";
            // En este caso es una orden hacia la base de datos, y no tenemos
            // ResultSet para iterar, puede ir bien o mal, nada más que hacer aquí

        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la base de datos (INSERT): " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos la sentencia y la conexión
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la base de datos: " + e.getMessage() + "</p>";
                e.printStackTrace();

            }
        }
        if (sLastError.isEmpty()) return resultado;
        else return resultado + sLastError;

    }

    // Método para obtener los pacientes ordenados por apellidos
    public String getPacientesPorApellidos() {
        String resultado = "";
        String id, nombre, apellidos, telefono, email, dni, sFNac;
        Connection con = null;
        Statement st = null;
        PreparedStatement ps = null;
        int iRows = 0;
        try {
            con = this.initDatabase();

            // st = con.createStatement();
            ps = con.prepareStatement("select * from Paciente order by apellidos");

            // ResultSet rs = st.executeQuery("select * from pacientes");
            ResultSet rs = ps.executeQuery();

            // Iteramos sobre el conjunto de resultados (resultset)
            while (rs.next()) {
                iRows++;
                id = (rs.getString("id"));
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                telefono = rs.getString("telefono");
                email = rs.getString("email");
                dni = rs.getString("dni");
                sFNac = rs.getString("sFNac");

                // Guardamos los resultados
                resultado += "<p>" + id + ";" +
                        nombre + ";" +
                        apellidos + ";" +
                        telefono + ";" +
                        email + ";" +
                        dni + ";" +
                        sFNac + "</p>\n";
            }
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la base de datos (SELECT): " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos la sentencia y la conexión
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la base de datos: " + e.getMessage() + "</p>";
                e.printStackTrace();

            }
        }
        resultado += "\n<p>Rows recogidas: " + iRows + "</p>\n";
        if (sLastError.isEmpty()) return resultado;
        else return resultado + sLastError;
    }

    public String getTodosTratamientos() {
        String resultado = "";
        String id_tratamiento, id_paciente, fecha, descripcion, coste;
        Connection con = null;
        Statement st = null;
        PreparedStatement ps = null;
        int iRows = 0;
        try {
            con = this.initDatabase();

            // st = con.createStatement();
            ps = con.prepareStatement("select * from  Tratamiento");

            // ResultSet rs = st.executeQuery("select * from pacientes");
            ResultSet rs = ps.executeQuery();

            // Iteramos sobre el conjunto de resultados (resultset)
            while (rs.next()) {
                iRows++;
                id_tratamiento = (rs.getString("id_tratamiento"));
                id_paciente = rs.getString("id_paciente");
                fecha = rs.getString("fecha");
                descripcion = rs.getString("descripcion");
                coste = rs.getString("coste");


                // Guardamos los resultados
                resultado += "<p>" + id_tratamiento + ";" +
                        id_paciente + ";" +
                        fecha + ";" +
                        descripcion + ";" +
                        coste + ";" + "</p>\n";
            }
        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la base de datos (SELECT): " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos la sentencia y la conexión
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la base de datos: " + e.getMessage() + "</p>";
                e.printStackTrace();

            }
        }
        resultado += "\n<p>Rows recogidas: " + iRows + "</p>\n";
        if (sLastError.isEmpty()) return resultado;
        else return resultado + sLastError;
    }

    public String insertPacienteJson(String sJson) {
        String resultado = "<p>Error al insertar</p>";
        Connection con = null;

        Gson gson = new Gson();
        Paciente miPc = gson.fromJson(sJson, Paciente.class);

        PreparedStatement ps = null;

        try {
            con = this.initDatabase();

            // st = con.createStatement();
            ps = con.prepareStatement("insert into Paciente (id,nombre,apellidos,telefono,email,dni,sFNac) values (?,?,?,?,?,?,?)");
            ps.setString(1, String.valueOf((int) (Math.random() * 100000)));
            ps.setString(2, miPc.getsNombre());
            ps.setString(3, miPc.getsApellidos());
            ps.setString(4, miPc.getsTelefono());
            ps.setString(5, miPc.getsEmail());
            ps.setString(6, miPc.getsDni());
            ps.setString(7, miPc.getsFNac());

            if (ps.executeUpdate() != 0)
                resultado = "<p>Paciente insertado correctamente</p>";
            else
                resultado = "<p>Algo ha salido mal con la sentencia Insert Pacientes</p>";
            // En este caso es una orden hacia la base de datos, y no tenemos
            // ResultSet para iterar, puede ir bien o mal, nada más que hacer aquí

        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la base de datos (INSERT): " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos la sentencia y la conexión
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la base de datos: " + e.getMessage() + "</p>";
                e.printStackTrace();

            }
        }
        if (sLastError.isEmpty()) return resultado;
        else return resultado + sLastError;

    }
    public String insertTratamientoJson(String sJson) {
        String resultado = "<p>Error al insertar</p>";
        Connection con = null;

        Gson gson = new Gson();
        Tratamiento miTr = gson.fromJson(sJson, Tratamiento.class);

        PreparedStatement ps = null;

        try {
            con = this.initDatabase();

            // st = con.createStatement();
            ps = con.prepareStatement("insert into Tratamiento (id_tratamiento,id_paciente,fecha,descripcion,coste) values (?,?,?,?,?)");
            ps.setString(1, String.valueOf((int) (Math.random() * 100000)));
            ps.setString(2, miTr.getsCodigo());
            ps.setString(3, miTr.getsFecha());
            ps.setString(4, miTr.getsDescripcion());
            ps.setFloat(5, miTr.getfPrecio());


            if (ps.executeUpdate() != 0)
                resultado = "<p>Tratamiento insertado correctamente</p>";
            else
                resultado = "<p>Algo ha salido mal con la sentencia Insert Tratamiento</p>";
            // En este caso es una orden hacia la base de datos, y no tenemos
            // ResultSet para iterar, puede ir bien o mal, nada más que hacer aquí

        } catch (Exception e) {
            sLastError = sLastError + "<p>Error accediendo a la base de datos (INSERT): " + e.getMessage() + "</p>";
            e.printStackTrace();
        } finally {
            // Liberamos recursos. Cerramos la sentencia y la conexión
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                sLastError = sLastError + "<p>Error cerrando la base de datos: " + e.getMessage() + "</p>";
                e.printStackTrace();

            }
        }
        if (sLastError.isEmpty()) return resultado;
        else return resultado + sLastError;

    }

}

