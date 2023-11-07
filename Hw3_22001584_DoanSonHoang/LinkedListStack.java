package Hw3_22001584_DoanSonHoang;

import java.util.Iterator;

public class LinkedListStack<T> implements StackInterface<T> {
    class Node {
        T element;
        Node next;
    }

    Node stack = null;

    @Override
    public void push(T element) {
        Node newNode = new Node();
        newNode.element = element;

        newNode.next = stack;
        stack = newNode;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }

        T data = stack.element;
        stack = stack.next;
        return data;
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }
        return stack.element;
    }
    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator<T> {

        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            // TODO Auto-generated method stub
            T data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}