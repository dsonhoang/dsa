package LT2_22001584_DoanSonHoang;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();

        myList.addFirst(-5);
        myList.add(16);
        myList.add(158);
        myList.add(-56);
        myList.add(0);
        myList.addAtIndex(1, 22);

        myList.removeFirst();
        myList.removeLast();
        myList.removeAtIndex(0);

        myList.set(1, -99);
        myList.remove(16);
        System.out.println("Contain 16?: " + myList.isContain(16));

        System.out.println("Size: " + myList.size());

        System.out.println("Is empty? " + myList.isEmpty());

        System.out.print("List elements: ");
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            Integer data = iterator.next();
            System.out.print(data + " ");
        }
    }
}
