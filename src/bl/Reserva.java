package bl;

// Definición de la clase Reserva, que representa una reserva en el hotel
public class Reserva {
    private Habitacion habitacion;  // Atributo para almacenar la habitación reservada
    private Huesped huesped;        // Atributo para almacenar el huésped que hizo la reserva
    private String fechaInicio;     // Fecha de inicio de la reserva
    private String fechaFin;        // Fecha de finalización de la reserva

    // Constructor de la clase Reserva, recibe una habitación, un huésped y fechas de inicio y fin
    public Reserva(Habitacion habitacion, Huesped huesped, String fechaInicio, String fechaFin) {
        this.habitacion = habitacion;   // Asigna la habitación recibida al atributo habitacion
        this.huesped = huesped;         // Asigna el huésped recibido al atributo huesped
        this.fechaInicio = fechaInicio; // Asigna la fecha de inicio recibida al atributo fechaInicio
        this.fechaFin = fechaFin;       // Asigna la fecha de fin recibida al atributo fechaFin
    }

    // Método para obtener la habitación asociada a la reserva
    public Habitacion getHabitacion() {
        return habitacion;
    }

    // Método para obtener el huésped asociado a la reserva
    public Huesped getHuesped() {
        return huesped;
    }
}
