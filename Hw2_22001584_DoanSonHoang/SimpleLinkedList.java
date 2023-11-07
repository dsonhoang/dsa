package Hw2_22001584_DoanSonHoang;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        Node new_node = new Node();
        new_node.data = data;

        if (isEmpty()) {
            top = new_node;
            bot = new_node;
        } else{
            new_node.next = top;
            top = new_node;
        }
        n++;
    }

    public void addBot(T data) {
        Node new_node = new Node();
        new_node.data = data;

        if (isEmpty()) {
            top = new_node;
            bot = new_node;
        } else {
            bot.next = new_node;
            bot = new_node;
        }
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= size()) {
            return null;
        }

        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= size()) {
            return;
        }

        Node current = top;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        current.data = data;
    }

    public boolean isContain(T data) {
        Node current = top;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (isEmpty()) {
            return null;
        } else {
            T topData = top.data;
            top = top.next;
            n--;
            return topData;
        }
    }

    public T removeBot() {
        if (isEmpty()) {
            return null;
        } else {
            T botData = bot.data;
            Node current_node = top;
            while (current_node.next != bot) {
                current_node = current_node.next;
            }
            current_node.next = null;
            bot = current_node;
            n--;
            return botData;
        }
    }

    public void remove(T data) {
        Node current_node = top;
        while (current_node.next != null) {
            if (current_node.next.data.equals(data)) {
                current_node.next = current_node.next.next;
                n--;
            } else {
                current_node = current_node.next;
            }
        }
    }
}
