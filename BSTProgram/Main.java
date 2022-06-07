package BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nodesDataList = new ArrayList<>(Arrays.asList(30, 10, 40, 20, 35, 50));
        BST bst = new BST();
        for (Integer nodeData : nodesDataList) {
            bst.insertNode(new Node(nodeData));
        }
        System.out.printf("%s%n",bst.getRoot());
        System.out.printf("%s%n",bst.getRoot().getLeft());
        System.out.printf("%s%n",bst.getRoot().getRight());
        System.out.printf("%s%n",bst.getRoot().getLeft().getLeft());
        System.out.printf("%s%n",bst.getRoot().getLeft().getRight());
        System.out.printf("%s%n",bst.getRoot().getRight().getLeft());
        System.out.printf("%s%n",bst.getRoot().getRight().getRight());
        bst.inorderRecursive();
    }
}
