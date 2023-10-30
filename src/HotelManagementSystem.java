import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Habitacion {

    // Declaración de variables miembro (atributos de la clase)
    private int numero;
    private String tipo;
    private int capacidad;
    private double precio;
    private boolean disponible;

    // Constructor de la clase Habitacion
    public Habitacion(int numero, String tipo, int capacidad, double precio) {

        // Inicializa los atributos de la clase con los valores proporcionados en el constructor
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.disponible = true;
    }

    // Método para reservar la habitación
    public void reservar() {
        disponible = false;
    }

    // Método para liberar la habitación
    public void liberar() {
        disponible = true;
    }

    // Método para verificar si la habitación está disponible
    public boolean estaDisponible() {
        return disponible;
    }

    // Métodos "get" para acceder a los atributos de la clase
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    // Método "set" para modificar el atributo 'tipo'
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Método "set" para modificar el atributo 'capacidad'
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Método "set" para modificar el atributo 'precio'
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}


class Huesped {

    // Declaración de atributos privados para almacenar información del huésped
    private String nombre;
    private String documento;
    private String telefono;

    // Constructor de la clase Huesped
    public Huesped(String nombre, String documento, String telefono) {
        // Inicializa los atributos de la clase con los valores proporcionados en el constructor
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    // Método para obtener el documento del huésped
    public String getDocumento() {
        return documento;
    }

    // Método para establecer o modificar el nombre del huésped
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el número de teléfono del huésped
    public String getTelefono() {
        return telefono;
    }

    // Método para establecer o modificar el número de teléfono del huésped
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

// Definición de la clase Reserva, que representa una reserva en el hotel
class Reserva {
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

public class HotelManagementSystem {
    public List<Habitacion> habitaciones = new ArrayList<>();
    private List<Huesped> huespedes = new ArrayList<>();
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


    // Método principal que ejecuta el programa de gestión del sistema de hotel
    public static void main(String[] args) {
        HotelManagementSystem hotelSystem = new HotelManagementSystem(); // Crea una instancia del sistema de gestión de hotel
        Scanner scanner = new Scanner(System.in); // Crea un objeto Scanner para la entrada del usuario

        // Bucle que permite al usuario interactuar con el sistema mediante un menú
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("|           Menú Cenfosuites         |"); // Muestra el título del menú
            System.out.println("--------------------------------------");
            System.out.println("|            HABITACIONES            |");
            System.out.println("--------------------------------------");
            System.out.println("1. Agregar Habitación                |"); // Opción para agregar una habitación
            System.out.println("2. Actualizar Habitación             |"); // Opción para actualizar detalles de una habitación
            System.out.println("3. Borrar Habitación                 |"); // Opción para eliminar una habitación
            System.out.println("--------------------------------------");
            System.out.println("|               HUESPEDES            |");
            System.out.println("--------------------------------------");
            System.out.println("4. Agregar Huésped                   |"); // Opción para agregar un huésped
            System.out.println("5. Actualizar Huésped                |"); // Opción para actualizar detalles de un huésped
            System.out.println("6. Borrar Huésped                    |"); // Opción para eliminar un huésped
            System.out.println("--------------------------------------");
            System.out.println("|               RESERVAS             |");
            System.out.println("--------------------------------------");
            System.out.println("7. Realizar Reserva                  |"); // Opción para realizar una reserva de habitación
            System.out.println("8. Cancelar Reserva                  |"); // Opción para cancelar una reserva de habitación
            System.out.println("9. Mostrar Habitaciones Disponibles  |"); // Opción para mostrar habitaciones disponibles
            System.out.println("--------------------------------------");
            System.out.println("10. Salir                            |"); // Opción para salir del programa
            System.out.println("--------------------------------------");
            System.out.println("Ingrese su opcion: ");

            int opcion = scanner.nextInt(); // Lee la opción ingresada por el usuario
            scanner.nextLine();  // Limpia el salto de línea después de leer la opción

            switch (opcion) {
                case 1:
                    // Agregar Habitación
                    System.out.print("Número de Habitación (numero entre 1 a 100): ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo (Ingrese suite, estándar o doble): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Capacidad (Ingrese 2, 4, 8): ");
                    int capacidad = scanner.nextInt();
                    System.out.print("Precio (suite $200, estándar $120, doble $150): ");
                    double precio = scanner.nextDouble();
                    Habitacion habitacion = new Habitacion(numero, tipo, capacidad, precio);
                    hotelSystem.agregarHabitacion(habitacion);
                    System.out.println("Habitación agregada con éxito.");
                    break;

                case 2:
                    // Actualizar Habitación
                    System.out.print("Número de Habitación a actualizar: ");
                    int numeroHabitacionActualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo Tipo: ");
                    String nuevoTipo = scanner.nextLine();
                    System.out.print("Nueva Capacidad: ");
                    int nuevaCapacidad = scanner.nextInt();
                    System.out.print("Nuevo Precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    hotelSystem.actualizarHabitacion(numeroHabitacionActualizar, nuevoTipo, nuevaCapacidad, nuevoPrecio);
                    break;

                case 3:
                    // Borrar Habitación
                    System.out.print("Número de Habitación a borrar: ");
                    int numeroHabitacionBorrar = scanner.nextInt();
                    hotelSystem.borrarHabitacion(numeroHabitacionBorrar);
                    break;

                case 4:
                    // Agregar Huésped
                    System.out.print("Nombre del Huésped (Ejemplo: Nombre Apellido): ");
                    String nombre = scanner.nextLine();
                    System.out.print("Documento de identidad (Ejemplo: 1 2345 6789): ");
                    String documento = scanner.nextLine();
                    System.out.print("Teléfono (Ejemplo: 45676789): ");
                    String telefono = scanner.nextLine();
                    Huesped huesped = new Huesped(nombre, documento, telefono);
                    hotelSystem.agregarHuesped(huesped);
                    System.out.println("Huésped agregado con éxito.");
                    break;

                case 5:
                    // Actualizar Huésped
                    System.out.print("Documento del Huésped a actualizar (Ejemplo: 1 2345 6789): ");
                    String documentoHuespedActualizar = scanner.nextLine();
                    System.out.print("Nuevo Nombre (Ejemplo: Nombre Apellido): ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo Teléfono (Ejemplo: 45676789): ");
                    String nuevoTelefono = scanner.nextLine();
                    hotelSystem.actualizarHuesped(documentoHuespedActualizar, nuevoNombre, nuevoTelefono);
                    break;

                case 6:
                    // Borrar Huésped
                    System.out.print("Documento del Huésped a borrar: ");
                    String documentoHuespedBorrar = scanner.nextLine();
                    hotelSystem.borrarHuesped(documentoHuespedBorrar);
                    break;

                case 7:
                    // Realizar Reserva
                    hotelSystem.mostrarHabitacionesDisponibles();
                    System.out.print("Seleccione el número de habitación: ");
                    int numeroHabitacion = scanner.nextInt();
                    Habitacion habitacionSeleccionada = null;
                    for (Habitacion habitacions : hotelSystem.habitaciones) {
                        if (habitacions.getNumero() == numeroHabitacion && habitacions.estaDisponible()) {
                            habitacionSeleccionada = habitacions;
                            break;
                        }
                    }
                    if (habitacionSeleccionada == null) {
                        System.out.println("La habitación seleccionada no está disponible o no existe.");
                    } else {
                        System.out.print("Documento del Huésped: ");
                        String documentoHuesped = scanner.next();
                        Huesped huespedSeleccionado = null;
                        for (Huesped huespeds : hotelSystem.huespedes) {
                            if (huespeds.getDocumento().equals(documentoHuesped)) {
                                huespedSeleccionado = huespeds;
                                break;
                            }
                        }
                        if (huespedSeleccionado == null) {
                            System.out.println("Huésped no encontrado.");
                        } else {
                            System.out.print("Fecha de Inicio (DD/MM/YYYY): ");
                            String fechaInicio = scanner.next();
                            System.out.print("Fecha de Fin (DD/MM/YYYY): ");
                            String fechaFin = scanner.next();
                            hotelSystem.realizarReserva(habitacionSeleccionada, huespedSeleccionado, fechaInicio, fechaFin);
                            System.out.println("Reserva realizada con éxito.");
                        }
                    }
                    break;

                case 8:
                    // Cancelar Reserva
                    System.out.print("Número de Habitación a cancelar reserva: ");
                    int numeroHabitacionCancelar = scanner.nextInt();
                    Habitacion habitacionCancelar = null;
                    for (Habitacion habitacions : hotelSystem.habitaciones) {
                        if (habitacions.getNumero() == numeroHabitacionCancelar && !habitacions.estaDisponible()) {
                            habitacionCancelar = habitacions;
                            break;
                        }
                    }
                    if (habitacionCancelar == null) {
                        System.out.println("La habitación seleccionada no tiene una reserva.");
                    } else {
                        hotelSystem.cancelarReserva(habitacionCancelar);
                    }
                    break;

                case 9:
                    // Mostrar Habitaciones Disponibles
                    hotelSystem.mostrarHabitacionesDisponibles();
                    break;

                case 10:
                    // Salir del sistema
                    System.out.println("Saliendo del sistema.");
                    System.exit(0);
                    break;

                default:
                    // Opción no válida
                    System.out.println("Opción no válida.");
            }
        }
    }
}
