import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Habitacion {
    private int numero;
    private String tipo;
    private int capacidad;
    private double precio;
    private boolean disponible;

    public Habitacion(int numero, String tipo, int capacidad, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.disponible = true;
    }

    public void reservar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

class Huesped {
    private String nombre;
    private String documento;
    private String telefono;

    public Huesped(String nombre, String documento, String telefono) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

class Reserva {
    private Habitacion habitacion;
    private Huesped huesped;
    private String fechaInicio;
    private String fechaFin;

    public Reserva(Habitacion habitacion, Huesped huesped, String fechaInicio, String fechaFin) {
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

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

    public void actualizarHabitacion(int numero, String tipo, int capacidad, double precio) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                habitacion.setTipo(tipo);
                habitacion.setCapacidad(capacidad);
                habitacion.setPrecio(precio);
                System.out.println("Habitación actualizada con éxito.");
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void borrarHabitacion(int numero) {
        Iterator<Habitacion> iterator = habitaciones.iterator();
        while (iterator.hasNext()) {
            Habitacion habitacion = iterator.next();
            if (habitacion.getNumero() == numero) {
                iterator.remove();
                System.out.println("Habitación eliminada con éxito.");
                return;
            }
        }
        System.out.println("Habitación no encontrada.");
    }

    public void agregarHuesped(Huesped huesped) {
        huespedes.add(huesped);
    }

    public void actualizarHuesped(String documento, String nombre, String telefono) {
        for (Huesped huesped : huespedes) {
            if (huesped.getDocumento().equals(documento)) {
                huesped.setNombre(nombre);
                huesped.setTelefono(telefono);
                System.out.println("Huésped actualizado con éxito.");
                return;
            }
        }
        System.out.println("Huésped no encontrado.");
    }

    public void borrarHuesped(String documento) {
        Iterator<Huesped> iterator = huespedes.iterator();
        while (iterator.hasNext()) {
            Huesped huesped = iterator.next();
            if (huesped.getDocumento().equals(documento)) {
                iterator.remove();
                System.out.println("Huésped eliminado con éxito.");
                return;
            }
        }
        System.out.println("Huésped no encontrado.");
    }

    public void realizarReserva(Habitacion habitacion, Huesped huesped, String fechaInicio, String fechaFin) {
        Reserva reserva = new Reserva(habitacion, huesped, fechaInicio, fechaFin);
        reservas.add(reserva);
        habitacion.reservar();
    }

    public void cancelarReserva(Habitacion habitacion) {
        habitacion.liberar();
        Iterator<Reserva> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getHabitacion() == habitacion) {
                iterator.remove();
            }
        }
        System.out.println("Reserva cancelada con éxito.");
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones Disponibles:");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible()) {
                System.out.println("Número: " + habitacion.getNumero() + ", Tipo: " + habitacion.getTipo() + ", Precio: $" + habitacion.getPrecio());
            }
        }
    }

    public static void main(String[] args) {
        HotelManagementSystem hotelSystem = new HotelManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("|           Menú Cenfosuites         |");
            System.out.println("--------------------------------------");
            System.out.println("|            HABITACIONES            |");
            System.out.println("--------------------------------------");
            System.out.println("1. Agregar Habitación                |");
            System.out.println("2. Actualizar Habitación             |");
            System.out.println("3. Borrar Habitación                 |");
            System.out.println("--------------------------------------");
            System.out.println("|               HUESPEDES            |");
            System.out.println("--------------------------------------");
            System.out.println("4. Agregar Huésped                   |");
            System.out.println("5. Actualizar Huésped                |");
            System.out.println("6. Borrar Huésped                    |");
            System.out.println("--------------------------------------");
            System.out.println("|               RESERVAS             |");
            System.out.println("--------------------------------------");
            System.out.println("7. Realizar Reserva                  |");
            System.out.println("8. Cancelar Reserva                  |");
            System.out.println("9. Mostrar Habitaciones Disponibles  |");
            System.out.println("--------------------------------------");
            System.out.println("10. Salir                            |");
            System.out.println("--------------------------------------");
            System.out.println("Ingrese su opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Número de Habitación (numero entre 1 a 100): ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tipo (Ingrese suite, estandar o doble): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Capacidad (Ingrese 2, 4, 8 ): ");
                    int capacidad = scanner.nextInt();
                    System.out.print("Precio (suite $200, estandar $120, doble $150): ");
                    double precio = scanner.nextDouble();
                    Habitacion habitacion = new Habitacion(numero, tipo, capacidad, precio);
                    hotelSystem.agregarHabitacion(habitacion);
                    System.out.println("Habitación agregada con éxito.");
                    break;
                case 2:
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
                    System.out.print("Número de Habitación a borrar: ");
                    int numeroHabitacionBorrar = scanner.nextInt();
                    hotelSystem.borrarHabitacion(numeroHabitacionBorrar);
                    break;
                case 4:
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
                    System.out.print("Documento del Huésped a actualizar (Ejemplo: 1 2345 6789): ");
                    String documentoHuespedActualizar = scanner.nextLine();
                    System.out.print("Nuevo Nombre (Ejemplo: Nombre Apellido): ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo Teléfono (Ejemplo: 45676789): ");
                    String nuevoTelefono = scanner.nextLine();
                    hotelSystem.actualizarHuesped(documentoHuespedActualizar, nuevoNombre, nuevoTelefono);
                    break;
                case 6:
                    System.out.print("Documento del Huésped a borrar: ");
                    String documentoHuespedBorrar = scanner.nextLine();
                    hotelSystem.borrarHuesped(documentoHuespedBorrar);
                    break;
                case 7:
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
                    hotelSystem.mostrarHabitacionesDisponibles();
                    break;
                case 10:
                    System.out.println("Saliendo del sistema.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
