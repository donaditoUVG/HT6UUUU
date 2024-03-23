/**
 * @author Jose Donado
 * 
 * Para manejar Colisiones con estrategia de listas utilizamos las tablas hash (estructura de clave - valor).
 * Multiples valores se asignarán en la misma
 */

 /**
  * Para la lista enlazada
  */


// pARA MANEJAR COLISIONES CON LA CLASE MAPANACIONALIDAD
class Nodo<K, V> {
    K key;
    V value;
    Nodo<K, V> next;

    public Nodo(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

