package pruebasUnitarias;

import static org.junit.Assert.*;
import bl.Habitacion;
import bl.Huesped;
import bl.Reserva;
import org.junit.Test;

public class ReservaTest {

    // verificar que el constructor de Reserva funciona correctamente
    @Test
    public void testConstructor() {
        // Creamos una instancia de Habitacion y una instancia de Huesped
        Habitacion habitacion = new Habitacion(101, "suite", 2, 200.0);
        Huesped huesped = new Huesped("Nombre Apellido", "1 2345 6789", "45676789");

        // Creamos una instancia de Reserva con la habitación, el huésped y fechas de inicio y fin
        Reserva reserva = new Reserva(habitacion, huesped, "01/01/2024", "05/01/2024");

        // Verificamos que la habitación y el huésped asociados a la reserva sean los correctos
        assertEquals(habitacion, reserva.getHabitacion());
        assertEquals(huesped, reserva.getHuesped());
    }
}
