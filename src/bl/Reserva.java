package bl;

// Definición de la clase Reserva, que representa una reserva en el hotel
public class Reserva {
    private Habitacion habitacion;
    private Huesped huesped;
    private String fechaInicio;
    private String fechaFin;

    // Constructor de la clase Reserva, recibe una habitación, un huésped y fechas de inicio y fin
    public Reserva(Habitacion habitacion, Huesped huesped, String fechaInicio, String fechaFin) {
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
