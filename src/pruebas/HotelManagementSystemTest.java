import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HotelManagementSystemTest {
    private HotelManagementSystem hotelSystem;

    @Before
    public void setUp() {
        hotelSystem = new HotelManagementSystem();
    }

    @Test
    public void testAgregarHabitacion() {
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200);
        hotelSystem.agregarHabitacion(habitacion);
        assertTrue(hotelSystem.habitaciones.contains(habitacion));
    }

    @Test
    public void testActualizarHabitacion() {
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200);
        hotelSystem.agregarHabitacion(habitacion);
        hotelSystem.actualizarHabitacion(101, "nuevaSuite", 3, 250);
        assertEquals("nuevaSuite", habitacion.getTipo());
        assertEquals(3, habitacion.getCapacidad());
        assertEquals(250.0, habitacion.getPrecio(), 0.001);
    }

    @Test
    public void testBorrarHabitacion() {
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200);
        hotelSystem.agregarHabitacion(habitacion);
        hotelSystem.borrarHabitacion(101);
        assertFalse(hotelSystem.habitaciones.contains(habitacion));
    }

    // Agrega más casos de prueba para otros métodos aquí...

}

