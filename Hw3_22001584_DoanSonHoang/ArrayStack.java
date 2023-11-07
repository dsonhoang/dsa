package Hw3_22001584_DoanSonHoang;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] stackArray;
    private int n = 0;
    private int defaultSize = 100;
    public ArrayStack() {
        stackArray = (E[]) new Object[defaultSize];
    }
    public ArrayStack(int capacity) {
        stackArray = (E[]) new Object[capacity];
    }

    @Override
    public void push(E data) {
        if (n == stackArray.length) {
            resizeArray(stackArray.length * 2);
        }
        stackArray[n] = data;
        n++;
    }

    public void resizeArray(int newSize) {
        E[] newArray = (E[]) new Object[stackArray.length * 2];
        System.arraycopy(stackArray, 0, newArray, 0, n);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E removedElement = stackArray[n - 1];
        stackArray[n - 1] = null;
        n--;
        return removedElement;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return stackArray[n - 1];
    }

    public int size() {
        return n;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = n - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    return null;
                }
                E next_element = stackArray[currentIndex];
                currentIndex--;
                return next_element;
            }
        };
    }
}

