package pruebasUnitarias;

import static org.junit.Assert.*;
import bl.Huesped; // Importamos la clase Huesped
import org.junit.Test;

public class HuespedTest {

    // Prueba para verificar que el constructor de Huesped funciona correctamente
    @Test
    public void testConstructor() {
        // Creamos una instancia de Huesped con valores iniciales
        Huesped huesped = new Huesped("Nombre Apellido", "1 2345 6789", "45676789");

        // Verificamos que los valores iniciales sean los correctos
        assertEquals("Nombre Apellido", huesped.getNombre());
        assertEquals("1 2345 6789", huesped.getDocumento());
        assertEquals("45676789", huesped.getTelefono());
    }

    // Prueba para verificar que el método 'setNombre' modifica el nombre del huésped
    @Test
    public void testSetNombre() {
        // Creamos una instancia de Huesped y modificamos su nombre
        Huesped huesped = new Huesped("Nombre Apellido", "1 2345 6789", "45676789");
        huesped.setNombre("Nuevo Nombre");

        // Verificamos que el nombre haya sido modificado correctamente
        assertEquals("Nuevo Nombre", huesped.getNombre());
    }

    // Prueba para verificar que el método 'setTelefono' modifica el teléfono del huésped
    @Test
    public void testSetTelefono() {
        // Creamos una instancia de Huesped y modificamos su número de teléfono
        Huesped huesped = new Huesped("Nombre Apellido", "1 2345 6789", "45676789");
        huesped.setTelefono("98765432");

        // Verificamos que el número de teléfono haya sido modificado correctamente
        assertEquals("98765432", huesped.getTelefono());
    }
}
