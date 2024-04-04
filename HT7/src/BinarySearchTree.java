package src;
public class BinarySearchTree<K extends Comparable<K>, V, F> {
    private TreeNode<K, V, F> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(K key, V value, F frenchValue) {
        this.root = insertRec(this.root, key, value, frenchValue);
    }

    private TreeNode<K, V, F> insertRec(TreeNode<K, V, F> root, K key, V value, F frenchValue) {
        if (root == null) {
            return new TreeNode<>(key, value, frenchValue);
        }
        int cmp = key.compareTo(root.getKey());
        if (cmp < 0) {
            root.setLeft(insertRec(root.getLeft(), key, value, frenchValue));
        } else if (cmp > 0) {
            root.setRight(insertRec(root.getRight(), key, value, frenchValue));
        } else {
            root.setValue(value);
        }
        return root;
    }

    public V find(K key) {
        return findRec(this.root, key);
    }

    private V findRec(TreeNode<K, V, F> root, K key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.getKey());
        if (cmp < 0) {
            return findRec(root.getLeft(), key);
        } else if (cmp > 0) {
            return findRec(root.getRight(), key);
        } else {
            return root.getValue();
        }
    }

    public TreeNode<K, V, F> getRoot() {
        return root;
    }
    

}
