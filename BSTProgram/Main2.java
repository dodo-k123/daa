package S1__22_03_22;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> dataArrList = new ArrayList<>();
        int[] dataArr = {10, 20, 40, 50, 25, 15};
//        int[] dataArr = {30, 70, 15, 35, 32, 37, 33};
        var bst1 = new BST(new Node(30));
//        var bst1 = new BST(new Node(50));
        for (int data : dataArr) {
            bst1.insertNode(new Node(data));
        }
        Node rootNode = bst1.root;
//        bst1.deleteNode(new Node(30));
//        System.out.println(rootNode);
//        System.out.println(rootNode.left);
//        System.out.println(rootNode.right);
//        System.out.println(rootNode.left.left);
//        System.out.println(rootNode.left.right);
//        System.out.println(rootNode.right.left);
//        System.out.println(rootNode.right.right);
//        System.out.println(rootNode.left.right.left);
//        System.out.println(rootNode.left.right.right);
        ArrayList<Node> inorderList =  bst1.inorder();
        System.out.println(inorderList);
    }
}
