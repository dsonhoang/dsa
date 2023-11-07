package LT6_22001584_DoanSonHoang;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayBinaryTree<Object, Object> arrayTree = new ArrayBinaryTree<>();
        arrayTree.setRoot(1);
        arrayTree.setLeft(1, 5);
        arrayTree.setRight(1, 3);
        arrayTree.setLeft(2, 8);
        arrayTree.setRight(2, 6);
        arrayTree.setLeft(3, 2);
        arrayTree.setRight(3, 7);

        System.out.println("Array Binary Tree: ");
        arrayTree.printTree(arrayTree.root(), "");

        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> linkedTree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> root = linkedTree.addRoot(1);
        linkedTree.addLeft(root, 5);
        linkedTree.addRight(root, 3);
        linkedTree.addLeft(root.getLeft(), 8);
        linkedTree.addRight(root.getLeft(), 6);
        linkedTree.addLeft(root.getRight(), 2);
        linkedTree.addRight(root.getRight(), 7);

        System.out.println("Linked Binary Tree: ");
        linkedTree.printTree(linkedTree.root(), "");
    }
}