package Hw2_22001584_DoanSonHoang;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;
    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }
    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }
    public void add(T data) {
        if (n == array.length) {
            resizeArray(array.length * 2);
        }
        array[n] = data;
        n++;
    }
    public T get(int i) {
        if (i < 0 || i >= n) {
            return null;
        }
        return array[i];
    }
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            return;
        }
        array[i] = data;
    }
    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                for (int j = i; j < n - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[n - 1] = null;
                n--;
            }
        }
    }
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    private void resizeArray(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < n;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    return null;
                } else {
                    T next_element = array[currentIndex];
                    currentIndex++;
                    return next_element;
                }
            }
        };
    }
}