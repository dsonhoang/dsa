package LT6_22001584_DoanSonHoang;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    public E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public void setRoot(E element) {
        array[1] = element;
    }

    public void enlarge() {
        E[] newArray = (E[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public int findIndex(T element) {
        int index = 0;
        for (; index < array.length; index++) {
            if (array[index] != null && ((T) array[index]).equals(element)) {
                break;
            }
        }

        return index;
    }

    public void setLeft(int p, E element) {
        if (2 * p >= array.length) {
            enlarge();
        }
        array[2 * p] = element;
        n++;
    }

    public void setRight(int p, E element) {
        if (2 * p + 1 >= array.length) {
            enlarge();
        }
        array[2 * p + 1] = element;
        n++;
    }

    public T root() {
        return (T) array[1];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int numChildren(T p) {
        int count = 0;
        int index = 0;
        for (; index < array.length; index++) {
            if (array[index] != null && ((T) array[index]).equals(p)) {
                break;
            }
        }

        if (index < array.length) {
            if (2 * index < array.length && array[2 * index] != null) {
                count++;
            }
            if (2 * index + 1 < array.length && array[2 * index + 1] != null) {
                count++;
            }

            return count;
        } else {
            return 0;
        }
    }

    public T parent(T p) {
        int index = findIndex(p);

        if (index < array.length) {
            return (T) array[index / 2];
        } else {
            return null;
        }
    }

    public T left(T p) {
        int index = findIndex(p);
        if (2 * index < array.length) {
            return (T)array[2 * index];
        } else {
            return null;
        }
    }

    public T right(T p) {
        int index = findIndex(p);
        if (2 * index + 1< array.length) {
            return (T)array[2 * index + 1];
        } else {
            return null;
        }
    }

    public T sibling(T p) {
        T parentNode = parent(p);
        if (parentNode != null) {
            if (left(parentNode).equals(p)) {
                return right(parentNode);
            } else {
                return left(parentNode);
            }
        } else {
            return null;
        }
    }

    public void printTree(T root, String range)
    {
        if (root == null) {
            return;
        }
        range += "     ";

        printTree(this.right(root), range);
        System.out.print(range + root + "\n");
        printTree(this.left(root), range);
    }

    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> myTree = new ArrayBinaryTree<>();
        myTree.setRoot(1);
        myTree.setLeft(1, 6);
        myTree.setRight(1, 7);

        myTree.setLeft(2, 4);
        myTree.setRight(2, 2);

        myTree.setLeft(3, 3);
        myTree.setRight(3, 5);

        System.out.println("Number children of \"6\" node is: " +myTree.numChildren(6));
        System.out.println("Left node of \"6\" node is: " +myTree.left(6));
        System.out.println("Right node of \"6\" node is: " +myTree.right(6));
        System.out.println("Sibling node of \"7\" node is: " +myTree.sibling(7));
    }
}

