package LT4_22001584_DoanSonHoang;
import java.util.Iterator;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("TEST ARRAY QUEUE");
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
        }

        System.out.println("Before Dequeue: ");
        Iterator<Integer> iterator = arrayQueue.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println("Element: " + element);
        }

        System.out.println("Dequeue: " + arrayQueue.dequeue());
        System.out.println("Dequeue: " + arrayQueue.dequeue());

        System.out.println("After Dequeue: ");
        iterator = arrayQueue.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println("Element: " + element);
        }

        System.out.println("TEST LINKED LIST QUEUE");
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        for (int i = 0; i < 5; i++) {
            linkedListQueue.enqueue(i);
        }

        System.out.println("Before Dequeue: ");
        Iterator<Integer> iterator2 = linkedListQueue.iterator();
        while (iterator2.hasNext()) {
            Integer element = iterator2.next();
            System.out.println("Element: " + element);
        }

        System.out.println("Dequeue: " + linkedListQueue.dequeue());
        System.out.println("Dequeue: " + linkedListQueue.dequeue());

        System.out.println("After Dequeue: ");
        iterator2 = linkedListQueue.iterator();
        while (iterator2.hasNext()) {
            Integer element = iterator2.next();
            System.out.println("Element: " + element);
        }
    }
}
