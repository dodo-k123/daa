package BST;

public class BST {
    public Node root;

    public BST() {
    }

    public BST(Node root) {
        this.root = root;
    }

    public void insertNode(Node newNode) {
        Node node = root;
        Node parentNode = null;
        if (node == null) {
            this.root = newNode;
            return;
        }
        while (node != null) {
            parentNode = node;
            if (isGreater(newNode, node)) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        insertToGivenNode(parentNode, newNode);
    }

    public void insertNodeRecursive(Node newNode) {
        insertNodeRecursiveStart(this.root, newNode);
    }

    public void inorderRecursive() {
        inorderRecursiveStart(this.getRoot());
    }

    //    returns true if node1 is strictly greater than node2
    private boolean isGreater(Node node1, Node node2) {
        return node1.getData() > node2.getData();
    }

    private void insertToGivenNode(Node parent, Node child) {
        if (isGreater(child, parent)) {
            parent.setRight(child);
            return;
        }
        parent.setLeft(child);
    }

    private Node insertNodeRecursiveStart(Node root, Node newNode) {
        if (this.root == null) {
            this.root = newNode;
            return root;
        }
        if (isGreater(newNode, root)) {
            this.root.setRight(insertNodeRecursiveStart(this.root.getRight(), newNode));
        } else {
            this.root.setLeft(insertNodeRecursiveStart(this.root.getRight(), newNode));
        }
        return root;
    }

    private void inorderRecursiveStart(Node root) {
        if (root != null) {
            inorderRecursiveStart(root.getLeft());
            System.out.println(root.getData());
            inorderRecursiveStart(root.getRight());
        }
    }

    public Node getRoot() {
        return this.root;
    }

}
