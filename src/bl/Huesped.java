package bl;

public class Huesped {

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

    public String getNombre() {
        return null;
    }
}
