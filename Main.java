/**
 * HashMap: Los elementos que inserta en el map no tendrán un orden específico. No aceptan claves duplicadas ni valores nulos.
TreeMap: El Mapa lo ordena de forma "natural". Por ejemplo, si la clave son valores enteros (como luego veremos), los ordena de menos a mayor.
LinkedHashMap: Inserta en el Map los elementos en el orden en el que se van insertando; 
es decir, que no tiene una ordenación de los elementos como tal, por lo que esta clase realiza las búsquedas de los 
elementos de forma más lenta que las demás clases.
 */
/**
 * @author Jose Donado
 */


 import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
public static void main(String[] args) {
        //Instancias de mis map
        Map<String, Estudiante> estudiantesMap = new HashMap<>();
        MapaNacionalidad mapaNacionalidad = new MapaNacionalidad();

        // Escoja el tipo de MAP
        MapType mapType = selectMapType();
        // Solicitar al usuario que seleccione el tipo de función hash
        HashFunction hashFunction = selectHashFunction();

        
        // Leer el contenido del archivo JSOn para poder almacenar los datos en el mapa
        LectorArchivo.leerEstudiantes(estudiantesMap, mapaNacionalidad, hashFunction);

        // Ejemplo de búsqueda por nacionalidad
        List<Estudiante> estudiantesPorNacionalidad = mapaNacionalidad.obtenerEstudiantesPorNacionalidad("Nigeria");
        System.out.println("Estudiantes de Nigeria:");
        for (Estudiante estudiante : estudiantesPorNacionalidad) {
            System.out.println(estudiante);
        }

        // Ejemplo de búsqueda individual por email
        String emailBuscado = "luctus.lobortis.class@aol.edu";
        String hashedEmail = hashFunction.hash(emailBuscado);
        Estudiante estudianteBuscado = estudiantesMap.get(hashedEmail);
        if (estudianteBuscado != null) {
            System.out.println("Estudiante encontrado: " + estudianteBuscado);
        } else {
            System.out.println("Estudiante con email " + emailBuscado + " no encontrado.");
        }
    }

    private static MapType selectMapType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de mapa:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int option = scanner.nextInt();
        scanner.nextLine(); 
        switch (option) {
            case 1:
                return MapType.HASHMAP;
            case 2:
                return MapType.TREEMAP;
            case 3:
                return MapType.LINKEDHASHMAP;
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido");
        }
    }

       
    /**
     * Seleccionar la funcion de HASH. Se dejó la orgánica por mera profilaxis
     * @return
     */
    private static HashFunction selectHashFunction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de función hash:");
        System.out.println("1. Orgánica (Sin modificar la llave)");
        System.out.println("2. MD5");
        System.out.println("3. SHA-1");
        int option = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        switch (option) {
            case 1:
                return new OrganicHashFunction();
            case 2:
                return new MD5HashFunction();
            case 3:
                return new SHAHashFunction();
            default:
                throw new IllegalArgumentException("Tipo de función hash no válido. Escogé uno de los 3 números");
        }
        
    }

   
}
