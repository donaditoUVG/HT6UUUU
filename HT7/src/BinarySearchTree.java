package src;
public class BinarySearchTree<K extends Comparable<K>, V, F> {
    private TreeNode<K, V, F> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(K key, V value, F frenchValue) {
        this.root = insertRec(this.root, key, value, frenchValue);
    }

    private TreeNode<K, V, F> insertRec(TreeNode<K, V, F> node, K key, V value, F frenchValue) {
        if (node == null) {
            return new TreeNode<>(key, value, frenchValue);
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(insertRec(node.getLeft(), key, value, frenchValue));
        } else if (cmp > 0) {
            node.setRight(insertRec(node.getRight(), key, value, frenchValue));
        } else {
            // Key already exists, update the value
            node.setValue(value);
            node.setFrenchValue(frenchValue);
        }

        return node;
    }

    public V find(K key) {
        return findRec(this.root, key);
    }

    private V findRec(TreeNode<K, V, F> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            return findRec(node.getLeft(), key);
        } else if (cmp > 0) {
            return findRec(node.getRight(), key);
        } else {
            return node.getValue();
        }
    }

    public void inOrderTraversal() {
        inOrderTraversalRec(root);
    }
    
    private void inOrderTraversalRec(TreeNode<K, V, F> node) {
        if (node != null) {
            inOrderTraversalRec(node.getLeft());
            System.out.println("Traducciones: " + node.getKey() + ", " + node.getValue() + ", " + node.getFrenchValue());
            inOrderTraversalRec(node.getRight());
        }
    }
    
}
