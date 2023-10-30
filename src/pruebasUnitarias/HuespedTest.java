package pruebasUnitarias;

import static org.junit.Assert.*;
import bl.Huesped;
import org.junit.Test;

public class HuespedTest {

    // verificar que el constructor de Huesped funciona correctamente
    @Test
    public void testConstructor() {
        // Creamos una instancia de Huesped con valores iniciales
        Huesped huesped = new Huesped("Pablo Quiros", "123456789", "45676789");

        // Verificamos que los valores iniciales sean los correctos
        assertEquals("Pablo Quiros", huesped.getNombre());
        assertEquals("123456789", huesped.getDocumento());
        assertEquals("45676789", huesped.getTelefono());
    }

    //verificar que el método setTelefono modifica el teléfono del huésped
    @Test
    public void testSetTelefono() {
        // Creamos una instancia de Huesped y modificamos su número de teléfono
        Huesped huesped = new Huesped("Andres Carvajal", "123456789", "45676789");
        huesped.setTelefono("98765432");

        // Verificamos que el número de teléfono haya sido modificado correctamente
        assertEquals("98765432", huesped.getTelefono());
    }
}
