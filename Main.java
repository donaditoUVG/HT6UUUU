import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instancias de mis map
        Map<String, Estudiante> estudiantesMap = null;
        MapaNacionalidad mapaNacionalidad = new MapaNacionalidad();

        // Escoja el tipo de MAP
        MapType mapType = selectMapType();
        switch (mapType) {
            case HASHMAP:
                estudiantesMap = MapFactory.createMap(MapType.HASHMAP);
                break;
            case TREEMAP:
                estudiantesMap = MapFactory.createMap(MapType.TREEMAP);
                break;
            case LINKEDHASHMAP:
                estudiantesMap = MapFactory.createMap(MapType.LINKEDHASHMAP);
                break;
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido");
        }

        // Solicitar al usuario que seleccione el tipo de función hash
        HashFunction hashFunction = selectHashFunction();

        // Leer el contenido del archivo JSOn para poder almacenar los datos en el mapa
        LectorArchivo.leerEstudiantes(estudiantesMap, mapaNacionalidad, hashFunction);

        // Mantener la interfaz abierta para permitir más operaciones
        while (true) {
            // Mostrar opciones al usuario
            mostrarOpciones();

            // Leer la opción del usuario
            int opcion = leerOpcion();

            // Realizar la acción correspondiente según la opción seleccionada
            switch (opcion) {
                case 1:
                    // Ejemplo de búsqueda por nacionalidad
                    buscarPorNacionalidad(mapaNacionalidad);
                    break;
                case 2:
                    // Ejemplo de búsqueda individual por email
                    buscarPorEmail(estudiantesMap, hashFunction);
                    break;
                case 3:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private static MapType selectMapType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de mapa:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
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

    private static HashFunction selectHashFunction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de función hash:");
        System.out.println("1. Orgánica (Sin modificar la llave)");
        System.out.println("2. MD5");
        System.out.println("3. SHA-1");
        int option = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        switch (option) {
            case 1:
                return new OrganicHashFunction();
            case 2:
                return new MD5HashFunction();
            case 3:
                return new SHA1HashFunction();
            default:
                throw new IllegalArgumentException("Tipo de función hash no válido. Escoge uno de los 3 números");
        }
    }

    private static void mostrarOpciones() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Buscar estudiantes por nacionalidad");
        System.out.println("2. Buscar estudiante por email");
        System.out.println("3. Salir");
    }

    private static int leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su opción: ");
        return scanner.nextInt();
    }

    private static void buscarPorNacionalidad(MapaNacionalidad mapaNacionalidad) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la nacionalidad a buscar: ");
        String nacionalidad = scanner.nextLine();
        List<Estudiante> estudiantes = mapaNacionalidad.obtenerEstudiantesPorNacionalidad(nacionalidad);
        System.out.println("Estudiantes de " + nacionalidad + ":");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    private static void buscarPorEmail(Map<String, Estudiante> estudiantesMap, HashFunction hashFunction) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el correo electrónico del estudiante a buscar: ");
        String email = scanner.nextLine();
        String hashedEmail = hashFunction.hash(email);
        Estudiante estudiante = estudiantesMap.get(hashedEmail);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante);
        } else {
            System.out.println("Estudiante con email " + email + " no encontrado.");
        }
    }
}
