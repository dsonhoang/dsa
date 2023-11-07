package LT4_22001584_DoanSonHoang;

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E>, Iterable<E> {
    private LinkedList<E> myList = new LinkedList<>();

    @Override
    public void enqueue(E element) {
        myList.addLast(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        return myList.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return myList.iterator();
    }
}