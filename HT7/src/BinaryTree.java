package src;

/**
 * Clase para representar un árbol binario de búsqueda genérico.
 * Puede almacenar valores de cualquier tipo que sea Comparable.
 *
 * @param <K> Tipo de la clave del nodo del árbol binario.
 * @param <V> Tipo del valor asociado en el primer idioma (en este caso, español).
 * @param <F> Tipo del valor asociado en el segundo idioma (en este caso, francés).
 */
public class BinaryTree<K extends Comparable<K>, V, F> {
    private K key;
    private V value;
    private F frenchValue;
    private BinaryTree<K, V, F> leftChild;
    private BinaryTree<K, V, F> rightChild;

    /**
     * Constructor para crear un nodo de árbol binario con una clave y valores dados.
     *
     * @param key         La clave del nodo del árbol binario.
     * @param value       El valor asociado en el primer idioma.
     * @param frenchValue El valor asociado en el segundo idioma.
     */
    public BinaryTree(K key, V value, F frenchValue) {
        this.key = key;
        this.value = value;
        this.frenchValue = frenchValue;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructor sin argumentos que crea un árbol binario vacío.
     */
    public BinaryTree() {
        this.key = null;
        this.value = null;
        this.frenchValue = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Inserta una nueva clave y valores asociados en el árbol binario de búsqueda.
     *
     * @param newKey       La nueva clave para insertar en el árbol.
     * @param newValue     El nuevo valor asociado en el primer idioma.
     * @param newFrenchValue El nuevo valor asociado en el segundo idioma.
     */
    public void insert(K newKey, V newValue, F newFrenchValue) {
        if (this.key == null) {
            this.key = newKey;
            this.value = newValue;
            this.frenchValue = newFrenchValue;
        } else {
            if (newKey.compareTo(this.key) < 0) {
                if (this.leftChild == null) {
                    this.leftChild = new BinaryTree<>(newKey, newValue, newFrenchValue);
                } else {
                    this.leftChild.insert(newKey, newValue, newFrenchValue);
                }
            } else if (newKey.compareTo(this.key) > 0) {
                if (this.rightChild == null) {
                    this.rightChild = new BinaryTree<>(newKey, newValue, newFrenchValue);
                } else {
                    this.rightChild.insert(newKey, newValue, newFrenchValue);
                }
            }
        }
    }

    /**
     * Busca un valor en el árbol binario de búsqueda y devuelve el nodo donde se encuentra.
     *
     * @param keyToFind La clave a buscar en el árbol.
     * @return El valor asociado al nodo encontrado, o null si la clave no se encuentra en el árbol.
     */
    public V find(K keyToFind) {
        if (keyToFind.compareTo(this.key) == 0) {
            return this.value;
        } else if (keyToFind.compareTo(this.key) < 0 && this.leftChild != null) {
            return this.leftChild.find(keyToFind);
        } else if (keyToFind.compareTo(this.key) > 0 && this.rightChild != null) {
            return this.rightChild.find(keyToFind);
        }
        return null;
    }

    /**
     * Realiza un recorrido inOrder del árbol binario y muestra las claves y valores asociados de los nodos.
     */
    public void inOrderTraversal() {
        if (this.leftChild != null) {
            this.leftChild.inOrderTraversal();
        }
        System.out.println("Clave: " + this.key + ", Valor: " + this.value + ", Valor en francés: " + this.frenchValue);
        if (this.rightChild != null) {
            this.rightChild.inOrderTraversal();
        }
    }

}
