package com.politecnicomalaga.TrabajoTallerServidor;

import static org.junit.Assert.*;
import org.junit.Test;

public class TratamientoTest {

    @Test
    public void testConstructor1() {
        Tratamiento tratamiento = new Tratamiento("TR001", "Tratamiento de prueba", "2021-01-01", 100.0f);
        assertEquals("TR001", tratamiento.getsCodigo());
        assertEquals("Tratamiento de prueba", tratamiento.getsDescripcion());
        assertEquals("2021-01-01", tratamiento.getsFecha());
        assertEquals(100.0f, tratamiento.getfPrecio(), 0.01);
        assertTrue(tratamiento.estaCobrado());
    }

    @Test
    public void testConstructor2() {
        Tratamiento tratamiento = new Tratamiento("Tratamiento;TR001;Tratamiento de prueba;2021-01-01;100.0;false\n");
        assertEquals("TR001", tratamiento.getsCodigo());
        assertEquals("Tratamiento de prueba", tratamiento.getsDescripcion());
        assertEquals("2021-01-01", tratamiento.getsFecha());
        assertEquals(100.0f, tratamiento.getfPrecio(), 0.01);
        assertFalse(tratamiento.estaCobrado());
    }

    @Test
    public void testCompara() {
        Tratamiento tratamiento = new Tratamiento("TR001", "Tratamiento de prueba", "2021-01-01", 100.0f);
        assertTrue(tratamiento.compara("TR001", AtributosTratamiento.CODIGO));
        assertTrue(tratamiento.compara("Tratamiento de prueba", AtributosTratamiento.DESCRIPCION));
        assertTrue(tratamiento.compara("2021-01-01", AtributosTratamiento.FECHA));
        assertTrue(tratamiento.compara(">90.0", AtributosTratamiento.PRECIO));
        assertTrue(tratamiento.compara("true", AtributosTratamiento.COBRADO));
        assertFalse(tratamiento.compara("false", AtributosTratamiento.COBRADO));
        assertFalse(tratamiento.compara("<100.0", AtributosTratamiento.PRECIO));
    }

    @Test
    public void testToString() {
        Tratamiento tratamiento = new Tratamiento("TR001", "Tratamiento de prueba", "2021-01-01", 100.0f);
        assertEquals("TR001#Tratamiento de prueba#2021-01-01#100.00 Cobrado: true", tratamiento.toString());
    }

    @Test
    public void testToCSV() {
        Tratamiento tratamiento = new Tratamiento("TR001", "Tratamiento de prueba", "2021-01-01", 100.0f);
        assertEquals("Tratamiento;TR001;Tratamiento de prueba;2021-01-01;100.0;true\n", tratamiento.toCSV());
    }

}
