package BST;

public class Node {
    private final int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    @Override
    public String toString() {
        return Integer.toString(this.getData());
    }
}
