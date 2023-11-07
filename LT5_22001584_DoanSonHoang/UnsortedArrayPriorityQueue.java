package LT5_22001584_DoanSonHoang;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    protected class ArrEntry<K, E> implements Entry<K, E>{
        K key;
        E element;
        public ArrEntry (K k, E e){
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public String toString() {
            return "(" + key + "," + element + ")";
        }
    }
    ArrEntry<K, E> [] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }

    public UnsortedArrayPriorityQueue(int capacity) {
        if (capacity < 0) {
            return;
        }
        array = new ArrEntry[capacity];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry entry) {
        if (n == array.length) {
            expandArray();
        }
        array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(Object k, Object e) {
        if (n == array.length) {
            expandArray();
        }
        ArrEntry<K, E> newEntry = new ArrEntry<K, E>((K)k, (E)e);
        array[n] = newEntry;
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }

        Entry<K, E> minEntry = array[minIndex];
        array[minIndex] = array[n - 1];
        array[n - 1] = null;
        n--;

        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }

        return array[minIndex];
    }

    public void expandArray() {
        ArrEntry<K, E>[] newArray = new ArrEntry[n * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                sb.append(array[i] + ", ");
            } else {
                sb.append(array[i]);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> priorityQueue = new UnsortedArrayPriorityQueue<>();

        priorityQueue.insert(3, "this");
        priorityQueue.insert(1, "is");
        priorityQueue.insert(2, "an");
        priorityQueue.insert(4, "apple");

        // In ra kích thước của hàng đợi ưu tiên
        System.out.println("Size: " + priorityQueue.size());

        // Lấy và in ra phần tử có giá trị nhỏ nhất
        Entry<Integer, String> minEntry = priorityQueue.min();
        System.out.println("Min Entry: Key=" + minEntry.getKey() + ", Value=" + minEntry.getValue());

        // Loại bỏ phần tử có giá trị nhỏ nhất
        Entry<Integer, String> removedEntry = priorityQueue.removeMin();
        System.out.println("Removed Entry: Key=" + removedEntry.getKey() + ", Value=" + removedEntry.getValue());

        // In ra kích thước của hàng đợi ưu tiên sau khi loại bỏ
        System.out.println("Size after removal: " + priorityQueue.size());
        System.out.println(priorityQueue);
    }
}