package LT4_22001584_DoanSonHoang;

public class MyCircularDeque {
    private int[] data;
    private int capacity;
    private int front;
    private int end;

    public MyCircularDeque(int k) {
        data = new int[k + 1];
        capacity = k;
        front = 0;
        end = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + data.length) % data.length;
        data[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[end] = value;
        end = (end + 1) % data.length;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % data.length;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        end = (end - 1 + data.length) % data.length;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    public int getEnd() {
        if (isEmpty()) {
            return -1;
        }
        return data[(end - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return front == end;
    }

    public boolean isFull() {
        return (end + 1) % data.length == front;
    }

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(10);
        System.out.println(obj.insertFront(1));
        System.out.println(obj.insertLast(2));
        System.out.println(obj.insertFront(3));
        System.out.println(obj.getEnd());
        System.out.println(obj.isFull());
        System.out.println(obj.deleteLast());
        System.out.println(obj.insertFront(4));
        System.out.println(obj.getFront());
        System.out.println(obj.isFull());
    }
}

