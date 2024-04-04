package src;
/**
 * Clase para representar una asociación genérica entre una clave y valores asociados en diferentes idiomas.
 *
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor asociado en el primer idioma.
 * @param <E> Tipo del valor asociado en el segundo idioma.
 * @param <F> Tipo del valor asociado en el tercer idioma.
 */
public class Association<K, V, E, F> implements Comparable<Association<K, V, E, F>> {
    private K key;
    private V value1;
    private E value2;
    private F value3;

    public Association(K key, V value1, E value2, F value3) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public K getKey() {
        return key;
    }

    public V getValue1() {
        return value1;
    }

    public E getValue2() {
        return value2;
    }

    public F getValue3() {
        return value3;
    }

    @Override
    public int compareTo(Association<K, V, E, F> other) {
        if (other == null) {
            return 1; // Esta asociación es mayor que null
        }
        if (this.key == null) {
            return other.key == null ? 0 : -1;
        }
        if (other.key == null) {
            return 1;
        }
        if (this.key instanceof Comparable && other.key instanceof Comparable) {
            Comparable<K> comparableKey = (Comparable<K>) this.key;
            return comparableKey.compareTo(other.key);
        }
        // No se puede comparar las claves, se devuelve 0
        return 0;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value1 + ", " + value2 + ", " + value3 + ")";
    }
}
