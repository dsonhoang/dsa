package LT4_22001584_DoanSonHoang;

public class MyCircularQueue {
    private int[] array;
    private int capacity;
    private int front;
    private int end;

    public MyCircularQueue(int k) {
        array = new int[k];
        capacity = k;
        front = -1;
        end = -1;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
        }
        end = (end + 1) % capacity;
        array[end] = value;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        if (front == end) {
            front = -1;
            end = -1;
        } else {
            front = (front + 1) % capacity;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    public int getEnd() {
        if (isEmpty()) {
            return -1;
        }
        return array[end];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((end + 1) % capacity) == front;
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(10);
        System.out.println(obj.enqueue(-5));
        System.out.println(obj.getEnd());
        System.out.println(obj.isFull());
        System.out.println(obj.dequeue());
        System.out.println(obj.getFront());
        System.out.println(obj.isFull());
    }
}