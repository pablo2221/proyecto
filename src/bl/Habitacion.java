package bl;

public class Habitacion {

    // Declaración de variables
    private int numero;
    private String tipo;
    private int capacidad;
    private double precio;
    private boolean disponible;

    // Constructor de la clase Habitacion
    public Habitacion(int numero, String tipo, int capacidad, double precio) {

        // Inicializa los atributos de la clase con valores proporcionados en el constructor
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

    // Método "set" para modificar el atributo tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // Método "set" para modificar el atributo capacidad
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
