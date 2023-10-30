package ui;

import bl.Habitacion;
import bl.HotelManagementSystem;
import bl.Huesped;
import java.util.Scanner;

// Método principal que ejecuta el programa de gestión del sistema de hotel
public class CenfoSuites {
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
                    System.out.print("Documento del Huésped a actualizar (Ejemplo: 123456789): ");
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