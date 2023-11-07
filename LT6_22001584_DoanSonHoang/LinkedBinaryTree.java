package LT6_22001584_DoanSonHoang;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {
    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public E getElement() {
            return element;
        }
    }

    private Node<E> root;
    private int n = 0;

    public Node<E> addRoot(E element) {
        Node<E> newNode = new Node<>(element, null, null, null);
        root = newNode;
        n++;
        return root;
    }

    public Node<E> getRoot(E element) {
        return this.root;
    }

    public Node<E> addLeft(Node p, E element) {
        if (p.left == null) {
            Node<E> newNode = new Node<E>(element, p, null, null);
            p.left = newNode;
            n++;
            return newNode;
        } else {
            return null;
        }
    }

    public Node<E> addRight(Node p, E element) {
        if (p.right == null) {
            Node<E> newNode = new Node<E>(element, p, null, null);
            p.right = newNode;
            n++;
            return newNode;
        } else {
            return null;
        }
    }

    public void set(Node p, E element) {
        p.element = element;
    }

    public T root() {
        return (T)root;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int numChildren(T p) {
        Node<E> node = (Node<E>) p;
        int count = 0;
        if (node.left != null) {
            count++;
        }
        if (node.right != null) {
            count++;
        }
        return count;
    }

    public T parent(T p) {
        Node<E> node = (Node<E>) p;
        if (node.parent != null) {
            return (T)node.parent.element;
        } else {
            return null;
        }
    }

    public T left(T p) {
        Node<E> node = (Node<E>) p;
        if (node.left != null) {
            return (T)node.left.element;
        } else {
            return null;
        }
    }

    public T right(T p) {
        Node<E> node = (Node<E>) p;
        if (node.right != null) {
            return (T)node.right.element;
        } else {
            return null;
        }
    }

    public T sibling(T p) {
        Node<E> node = (Node<E>) p;
        Node<E> parent = node.parent;
        if (node.parent != null) {
            if (node.equals(node.parent.left)) {
                return (T)parent.right.element;
            } else {
                return (T)parent.left.element;
            }
        } else {
            return null;
        }
    }
    public void printTree(Node root, String range)
    {
        if (root == null)
            return;

        range += "     ";

        printTree(root.right, range);
        System.out.print(range + root.element + "\n");
        printTree(root.left, range);
    }

    public static void main(String[] args) {
        LinkedBinaryTree<String, Node<String>> tree = new LinkedBinaryTree<>();

        Node<String> root = tree.addRoot("A");
        Node<String> nodeB = tree.addLeft(root, "B");
        Node<String> nodeC = tree.addRight(root, "C");
        Node<String> nodeD = tree.addLeft(nodeB, "D");
        Node<String> nodeE = tree.addRight(nodeB, "E");
        Node<String> nodeF = tree.addLeft(nodeC, "F");
        Node<String> nodeG = tree.addRight(nodeC, "G");

        System.out.println("Root: " + tree.root());
        System.out.println("Size: " + tree.size());
        System.out.println("Is Empty? " + tree.isEmpty());
        System.out.println("Number of children of B: " + tree.numChildren(nodeB));
        System.out.println("Parent of D: " + tree.parent(nodeD));
        System.out.println("Left child of B: " + tree.left(nodeB));
        System.out.println("Right child of B: " + tree.right(nodeB));
        System.out.println("Sibling of C: " + tree.sibling(nodeC));
    }
}