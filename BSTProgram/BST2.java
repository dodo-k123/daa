package S1__22_03_22;

import java.util.ArrayList;

public class BST {
    public Node root;

    public BST() {
        this.root = null;
    }

    public BST(Node root) {
        this.root = root;
    }

    public void insertToCurrentNode(Node node, Node newNode) {
        if (newNode.data < node.data) {
            node.left = newNode;
        } else {
            node.right = newNode;
        }
    }

    public int compareNode(Node node1, Node node2) {
        if (node1.data < node2.data) {
            return -1;
        } else if (node1.data > node2.data) {
            return 1;
        }
        return 0;
    }

    public void insertNode(Node newNode) {
        if (root == null) {
            root = newNode;
            return;
        }
        Node node = root;
        while (true) {
            if (compareNode(newNode, node) == 1) {
                if (node.right == null) {
                    break;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    break;
                }
                node = node.left;
            }
        }
        insertToCurrentNode(node, newNode);
    }

    public int childCount(Node node) {
        if (node.left == null && node.right == null) {
            return 0;
        } else if (node.left != null && node.right != null) {
            return 2;
        }
        // Node has 1 child
        return 1;
    }

    public void replaceNodes(Node node1, Node node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public void deleteNode(Node delNode) {
        Node node = root;
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        Node parentNode = null;

        while (true) {
            nodeArrayList.add(node);
            if (compareNode(delNode, node) == -1) {
                node = node.left;
            } else if (compareNode(delNode, node) == 1) {
                node = node.right;
            } else {
                break;
            }
        }

        nodeArrayList.remove(nodeArrayList.size() - 1);
        parentNode = nodeArrayList.remove(nodeArrayList.size() - 1);

        // if node has one child
        if (childCount(node) == 1) {
            if (compareNode(node, parentNode) == 1) {
                parentNode.right = node.right;
            } else {
                parentNode.left = node.left;
            }
            return;
        }

        // if node is a leaf node
        if (childCount(node) == 0) {
            assert parentNode != null;
            if (compareNode(node, parentNode) == 1) {
                parentNode.right = null;
            } else {
                parentNode.left = null;
            }
            return;
        }

        // if node has 2 children
//        while not a leaf node
        while (!(childCount(node) == 0)) {
            ArrayList<Node> inorderList = this.inorder();
//            System.out.println(inorderList);
            for (int i = 0; i < inorderList.size(); i++) {
                Node temp_node = inorderList.get(i);
                if (compareNode(temp_node, node) == 0) {
                    Node node_successor = inorderList.get(i + 1);
                    replaceNodes(node, node_successor);
                    parentNode = node;
                    node = node_successor;
//                    System.out.println(node);
//                    System.out.println(parentNode);
                    break;
                }
            }
        }
//        After it becomes a leaf node, we put the parent node.right as null because we always replace the current node with a successor node
        parentNode.right = null;
    }

    public ArrayList<Node> inorder() {
        ArrayList<Node> nodeArrayList = new ArrayList<>();
        ArrayList<Node> inorderList = new ArrayList<>();
        Node node = root;
        while (!nodeArrayList.isEmpty() || node != null) {
            if (node != null) {
                nodeArrayList.add(node);
                node = node.left;
            } else {
                node = nodeArrayList.remove(nodeArrayList.size() - 1);
                inorderList.add(node);
                node = node.right;
            }
        }
        return inorderList;
    }
}
