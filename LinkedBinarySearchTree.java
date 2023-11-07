package OnTap;

public class LinkedBinarySearchTree<E extends Comparable<E>> implements LinkedBinarySearchTreeInterface<E> {
    protected static class Node<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }
    }

    private Node<E> root;
    private int n = 0;

    public E root() {
        return this.root.getElement();
    }

    public E parent(E p) {
        Node<E> node = findNode(root, p);
        if (node != null && !node.equals(root)) {
            return node.getParent().getElement();
        }
        return null;
    }

    public Node<E> findNode(Node<E> currentNode, E p) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.getElement().equals(p)) {
            return currentNode;
        }

        Node<E> leftFind = findNode(currentNode.getLeft(), p);
        if (leftFind != null) {
            return leftFind;
        }

        Node<E> rightFind = findNode(currentNode.getRight(), p);
        if (rightFind != null) {
            return rightFind;
        }

        return null;
    }

    public E left(E p) {
        Node<E> node = findNode(root, p);

        if (node != null) {
            return node.getLeft().getElement();
        } else {
            return null;
        }
    }

    public E right(E p) {
        Node<E> node = findNode(root, p);

        if (node != null) {
            return node.getRight().getElement();
        } else {
            return null;
        }
    }

    public E sibling(E p) {
        Node<E> parrentNode = findNode(root, parent(p));
        if (parrentNode != null) {
            if (parrentNode.getLeft().getElement() != null &&
                    parrentNode.getLeft().getElement().equals(p)) {
                return parrentNode.getRight().getElement();
            } else if (parrentNode.getRight().getElement() != null &&
                    parrentNode.getRight().getElement().equals(p)) {
                return parrentNode.getLeft().getElement();
            }
        }

        return null;
    }

    public E findMax() {
        if (root == null) {
            return null;
        }

        Node<E> currentNode = root;
        while (currentNode.getRight() != null) {
            currentNode = currentNode.getRight();
        }

        return currentNode.getElement();
    }

    public E findMin() {
        if (root == null) {
            return null;
        }

        Node<E> currentNode = root;
        while (currentNode.getLeft() != null) {
            currentNode = currentNode.getLeft();
        }

        return currentNode.getElement();
    }

    public void insert(E p) {
        root = insert(root, p, null);
        n++;
    }

    private Node insert(Node<E> currentNode, E p, Node<E> parent) {
        if (currentNode == null) {
            return new Node(p, parent, null, null);
        }

        int compareValue = p.compareTo(currentNode.getElement());
        if (compareValue < 0) {
            //add to the left
            currentNode.setLeft(insert(currentNode.getLeft(), p, currentNode));
        } else if (compareValue > 0) {
            //add to the right
            currentNode.setRight(insert(currentNode.getRight(), p, currentNode));
        }

        return currentNode;
    }

    public void delete(E element) {
        if (this.search(element)) {
            root = delete(root, element);
            n--;
        }
    }

    public Node<E> delete(Node<E> currentNode, E element) {
        if (currentNode == null) {
            return currentNode;
        }
        int compareValue = element.compareTo(currentNode.getElement());

        if (compareValue < 0) {
            //delete in the left
            currentNode.setLeft(delete(currentNode.getLeft(), element));
        } else if (compareValue > 0) {
            //delete in the right
            currentNode.setRight(delete(currentNode.getRight(), element));
        } else {
            //Delete current node
            //Case1: Node with one child or no child
            if (currentNode.getLeft() == null) {
                return currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                return currentNode.getLeft();
            }

            //Case2: Node with 2 children
            currentNode.setElement(findMinValue(currentNode.getRight()));
            currentNode.setRight(delete(currentNode.getRight(), currentNode.getElement()));
        }

        return currentNode;
    }

    private E findMinValue(Node<E> node) {
        E minValue = node.getElement();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getElement();
            node = node.getLeft();
        }
        return minValue;
    }

    public boolean search(E p) {
        return search(root, p);
    }

    private boolean search(Node<E> currentNode, E p) {
        if (currentNode == null) {
            return false;
        }

        int comparisonResult = p.compareTo(currentNode.getElement());

        if (comparisonResult == 0) {
            return true;
        } else if (comparisonResult < 0) {
            return search(currentNode.getLeft(), p);
        } else {
            return search(currentNode.getRight(), p);
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void clear() {
        root = null;
        n = 0;
    }

    @Override
    public int numChildren(E p) {
        int count = 0;
        Node<E> node = findNode(root, p);
        if (node.getLeft() != null) {
            count++;
        }

        if (node.getRight() != null) {
            count++;
        }

        return count;
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node<E> node, int level) {
        if (node == null) {
            return;
        }

        printTree(node.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    "); // Adjust the number of spaces for indentation
        }
        System.out.println(node.getElement());

        printTree(node.getLeft(), level + 1);
    }

    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<>();

        // Insert elements into the tree
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);

        // Print the tree's size
        System.out.println("Tree size: " + tree.size());

        // Check if the tree is empty
        System.out.println("Is the tree empty? " + tree.isEmpty());

        // Perform various tree operations
        System.out.println("Root element: " + tree.root());
        System.out.println("Parent of 7: " + tree.parent(7));
        System.out.println("Left child of 15: " + tree.left(15));
        System.out.println("Right child of 15: " + tree.right(15));
        System.out.println("Sibling of 12: " + tree.sibling(12));

        // Find and print the minimum and maximum elements
        System.out.println("Minimum element: " + tree.findMin());
        System.out.println("Maximum element: " + tree.findMax());

        // Search for elements in the tree
        System.out.println("Is 12 in the tree? " + tree.search(12));
        System.out.println("Is 20 in the tree? " + tree.search(20));

        // Get the number of children of an element
        System.out.println("Number of children of 5: " + tree.numChildren(5));

        System.out.println("Tree: "); tree.printTree();

        System.out.println("Delete element 5");
        tree.delete(5);

        System.out.println("Tree after deletion: "); tree.printTree();
        // Clear the tree
        tree.clear();
        System.out.println("Tree size after clearing: " + tree.size());
    }
}
