/**
 * Para manejar Colisiones con estrategia de listas utilizamos las tablas hash (estructura de clave - valor).
 * Multiples valores se asignarán en la misma
 */
// esta maneja colisiones con encadenamiento

import java.util.List;
import java.util.ArrayList;

public class MapaNacionalidad {
    private static final int TAMANO = 100; // Tamaño de la tabla hash
    private List<Nodo<String, Estudiante>> tabla;

    public MapaNacionalidad() {
        tabla = new ArrayList<>(TAMANO);
        for (int i = 0; i < TAMANO; i++) {
            tabla.add(null);
        }
    }

    // Método para agregar un estudiante al mapa por nacionalidad
    public void agregarEstudiantePorNacionalidad(String nacionalidad, Estudiante estudiante) {
        int indice = obtenerIndice(nacionalidad);
        Nodo<String, Estudiante> nodoActual = tabla.get(indice);
        
        if (nodoActual == null) {
            tabla.set(indice, new Nodo<>(nacionalidad, estudiante));
        } else {
            while (nodoActual.next != null) {
                nodoActual = nodoActual.next;
            }
            nodoActual.next = new Nodo<>(nacionalidad, estudiante);
        }
    }

    // Método para obtener la lista de estudiantes por nacionalidad
    public List<Estudiante> obtenerEstudiantesPorNacionalidad(String nacionalidad) {
        List<Estudiante> estudiantes = new ArrayList<>();
        int indice = obtenerIndice(nacionalidad);
        Nodo<String, Estudiante> nodoActual = tabla.get(indice);

        while (nodoActual != null) {
            if (nodoActual.key.equals(nacionalidad)) {
                estudiantes.add(nodoActual.value);
            }
            nodoActual = nodoActual.next;
        }

        return estudiantes;
    }

    // Jalar el índice en la tabla hash
    private int obtenerIndice(String key) {
        return Math.abs(key.hashCode() % TAMANO);
    }
}


