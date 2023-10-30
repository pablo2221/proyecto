package pruebasUnitarias;

import static org.junit.Assert.*;

import bl.Habitacion; // Importamos la clase Habitacion
import org.junit.Test;

public class HabitacionTest {

    // Prueba para verificar que el constructor de Habitacion funciona correctamente
    @Test
    public void testConstructor() {
        // Creamos una instancia de Habitacion con valores iniciales
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200.0);

        // Verificamos que los valores iniciales sean los correctos
        assertEquals(101, habitacion.getNumero());
        assertEquals("suite", habitacion.getTipo());
        assertEquals(2, habitacion.getCapacidad());
        assertEquals(200.0, habitacion.getPrecio(), 0.01); // Utilizamos delta para la comparación de valores flotantes
        assertTrue(habitacion.estaDisponible());
    }

    // Prueba para verificar que el método 'reservar' cambia la disponibilidad de la habitación
    @Test
    public void testReservar() {
        // Creamos una instancia de Habitacion y la reservamos
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200.0);
        habitacion.reservar();

        // Verificamos que la habitación ya no está disponible
        assertFalse(habitacion.estaDisponible());
    }

    // Prueba para verificar que el método 'liberar' cambia la disponibilidad de la habitación
    @Test
    public void testLiberar() {
        // Creamos una instancia de Habitacion, la reservamos y luego la liberamos
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200.0);
        habitacion.reservar();
        habitacion.liberar();

        // Verificamos que la habitación vuelve a estar disponible
        assertTrue(habitacion.estaDisponible());
    }

    // Prueba para verificar que el método 'setTipo' modifica el tipo de la habitación
    @Test
    public void testSetTipo() {
        // Creamos una instancia de Habitacion y modificamos su tipo
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200.0);
        habitacion.setTipo("nuevaSuite");

        // Verificamos que el tipo haya sido modificado correctamente
        assertEquals("nuevaSuite", habitacion.getTipo());
    }

    // Prueba para verificar que el método 'setCapacidad' modifica la capacidad de la habitación
    @Test
    public void testSetCapacidad() {
        // Creamos una instancia de Habitacion y modificamos su capacidad
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200.0);
        habitacion.setCapacidad(3);

        // Verificamos que la capacidad haya sido modificada correctamente
        assertEquals(3, habitacion.getCapacidad());
    }

    // Prueba para verificar que el método 'setPrecio' modifica el precio de la habitación
    @Test
    public void testSetPrecio() {
        // Creamos una instancia de Habitacion y modificamos su precio
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200.0);
        habitacion.setPrecio(250.0);

        // Verificamos que el precio haya sido modificado correctamente
        assertEquals(250.0, habitacion.getPrecio(), 0.01);
    }
}
