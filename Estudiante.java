import java.util.List;
import java.util.Map;

public class Estudiante {
    private String name;
    private String phone;
    private String email;
    private String postalZip;
    private String country;

    // Constructor
    public Estudiante(String name, String phone, String email, String postalZip, String country) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.postalZip = postalZip;
        this.country = country;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Método Auxiliar para imprimir datos
    @Override
    public String toString() {
        return "Estudiante{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", postalZip='" + postalZip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    // Método de búsqueda de estudiantes por llave seleccionada
    public static Estudiante buscarEstudiantePorLlave(Map<String, Estudiante> estudiantesMap, String llave, HashFunction hashFunction) {
        String hashedLlave = hashFunction.hash(llave); // Asegúrate de tener hashFunction disponible
        return estudiantesMap.get(hashedLlave);
    }

    // Método de búsqueda de estudiantes por nacionalidad
    public static List<Estudiante> buscarEstudiantesPorNacionalidad(MapaNacionalidad mapaNacionalidad, String nacionalidad) {
        return mapaNacionalidad.obtenerEstudiantesPorNacionalidad(nacionalidad);
    }

    // Método para mostrar la información del estudiante en la consola
    public void mostrarInformacionEstudianteEnConsola() {
        System.out.println("Nombre: " + name);
        System.out.println("Teléfono: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Código Postal: " + postalZip);
        System.out.println("País: " + country);
    }
}
