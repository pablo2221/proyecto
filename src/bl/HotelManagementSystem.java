package bl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HotelManagementSystem {
    public List<Habitacion> habitaciones = new ArrayList<>();
    public List<Huesped> huespedes = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    // Método para actualizar los detalles de una habitación en el sistema
    public void actualizarHabitacion(int numero, String tipo, int capacidad, double precio) {
        // Iterar a través de la lista de habitaciones en el sistema
        for (Habitacion habitacion : habitaciones) {
            // Verificar si el número de la habitación coincide con el número proporcionado
            if (habitacion.getNumero() == numero) {
                // Actualizar los detalles de la habitación con los valores proporcionados
                habitacion.setTipo(tipo);
                habitacion.setCapacidad(capacidad);
                habitacion.setPrecio(precio);
                // Mostrar un mensaje de éxito
                System.out.println("Habitación actualizada con éxito.");
                return; // Salir del bucle ya que se encontró y actualizó la habitación
            }
        }
        // Si el bucle termina y no se encontró una habitación con el número dado, mostrar un mensaje de error
        System.out.println("Habitación no encontrada.");
    }


    // Método para borrar una habitación del sistema por su número
    public void borrarHabitacion(int numero) {
        // Crear un iterador para recorrer la lista de habitaciones
        Iterator<Habitacion> iterator = habitaciones.iterator();

        // Iniciar un bucle while para recorrer la lista
        while (iterator.hasNext()) {
            // Obtener la siguiente habitación de la lista
            Habitacion habitacion = iterator.next();

            // Verificar si el número de la habitación coincide con el número proporcionado
            if (habitacion.getNumero() == numero) {
                // Si la habitación se encuentra, eliminarla utilizando el iterador
                iterator.remove();

                // Mostrar un mensaje de éxito
                System.out.println("Habitación eliminada con éxito.");

                return; // Salir del bucle ya que se encontró y eliminó la habitación
            }
        }

        // Si el bucle termina y no se encontró una habitación con el número dado, mostrar un mensaje de error
        System.out.println("Habitación no encontrada.");
    }


    // Método para agregar un nuevo huésped al sistema
    public void agregarHuesped(Huesped huesped) {
        huespedes.add(huesped); // Agrega el objeto Huesped a la lista de huéspedes en el sistema
    }

    // Método para actualizar los detalles de un huésped en el sistema
    public void actualizarHuesped(String documento, String nombre, String telefono) {
        // Itera a través de la lista de huéspedes en el sistema
        for (Huesped huesped : huespedes) {
            // Verifica si el documento de identidad del huésped coincide con el documento proporcionado
            if (huesped.getDocumento().equals(documento)) {
                // Actualiza el nombre y el número de teléfono del huésped con los valores proporcionados
                huesped.setNombre(nombre);
                huesped.setTelefono(telefono);

                // Muestra un mensaje de éxito
                System.out.println("Huésped actualizado con éxito.");
                return; // Sale del bucle ya que se encontró y actualizó el huésped
            }
        }

        // Si el bucle termina y no se encontró un huésped con el documento dado, muestra un mensaje de error
        System.out.println("Huésped no encontrado.");
    }

    // Método para eliminar un huésped del sistema por su documento de identidad
    public void borrarHuesped(String documento) {
        // Crea un iterador para recorrer la lista de huéspedes
        Iterator<Huesped> iterator = huespedes.iterator();

        // Inicia un bucle while para recorrer la lista
        while (iterator.hasNext()) {
            // Obtiene el siguiente huésped de la lista
            Huesped huesped = iterator.next();

            // Verifica si el documento de identidad del huésped coincide con el documento proporcionado
            if (huesped.getDocumento().equals(documento)) {
                // Si el huésped se encuentra, elimínalo utilizando el iterador
                iterator.remove();

                // Muestra un mensaje de éxito
                System.out.println("Huésped eliminado con éxito.");

                return; // Sale del bucle ya que se encontró y eliminó el huésped
            }
        }

        // Si el bucle termina y no se encontró un huésped con el documento dado, muestra un mensaje de error
        System.out.println("Huésped no encontrado.");
    }

    // Método para realizar una reserva de habitación por un huésped en el sistema
    public void realizarReserva(Habitacion habitacion, Huesped huesped, String fechaInicio, String fechaFin) {
        // Crea un objeto Reserva con la información proporcionada
        Reserva reserva = new Reserva(habitacion, huesped, fechaInicio, fechaFin);

        // Agrega la reserva a la lista de reservas en el sistema
        reservas.add(reserva);

        // Marca la habitación como reservada
        habitacion.reservar();
    }

    // Método para cancelar una reserva de habitación
    public void cancelarReserva(Habitacion habitacion) {
        habitacion.liberar(); // Marca la habitación como disponible
        Iterator<Reserva> iterator = reservas.iterator();

        // Inicia un bucle while para recorrer la lista de reservas
        while (iterator.hasNext()) {
            // Obtiene la siguiente reserva de la lista
            Reserva reserva = iterator.next();

            // Verifica si la habitación de la reserva coincide con la habitación proporcionada
            if (reserva.getHabitacion() == habitacion) {
                // Si la reserva se encuentra, elimínala utilizando el iterador
                iterator.remove();
            }
        }

        // Muestra un mensaje de éxito después de cancelar la reserva
        System.out.println("Reserva cancelada con éxito.");
    }

    // Método para mostrar las habitaciones disponibles en el sistema
    public void mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones Disponibles:");

        // Itera a través de la lista de habitaciones en el sistema
        for (Habitacion habitacion : habitaciones) {
            // Verifica si la habitación está disponible
            if (habitacion.estaDisponible()) {
                // Muestra información de la habitación, incluyendo número, tipo y precio
                System.out.println("Número: " + habitacion.getNumero() + ", Tipo: " + habitacion.getTipo() + ", Precio: $" + habitacion.getPrecio());
            }
        }
    }
}
