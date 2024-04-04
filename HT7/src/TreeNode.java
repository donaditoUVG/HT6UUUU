package src;

public class TreeNode<K, V, F> {
    private K key;
    private V value;
    private F frenchValue;
    private TreeNode<K, V, F> left;
    private TreeNode<K, V, F> right;
    private TreeNode<K, V, F> parent;

    public TreeNode(K key, V value, F frenchValue) {
        this.key = key;
        this.value = value;
        this.frenchValue = frenchValue;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public F getFrenchValue() {
        return frenchValue;
    }

    public void setFrenchValue(F frenchValue) {
        this.frenchValue = frenchValue;
    }

    public TreeNode<K, V, F> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<K, V, F> left) {
        this.left = left;
    }

    public TreeNode<K, V, F> getRight() {
        return right;
    }

    public void setRight(TreeNode<K, V, F> right) {
        this.right = right;
    }

    public TreeNode<K, V, F> getParent() {
        return parent;
    }

    public void setParent(TreeNode<K, V, F> parent) {
        this.parent = parent;
    }
}
