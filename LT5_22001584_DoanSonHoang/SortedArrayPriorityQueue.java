package LT5_22001584_DoanSonHoang;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
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

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }

    public SortedArrayPriorityQueue(int capacity) {
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

        int mark = n;

        for (int i = 0; i < n; i++) {
            if (String.valueOf(entry.getKey()).compareTo(String.valueOf(array[i].getKey())) > 0) {
                mark = i;
                break;
            }
        }

        for (int j = n; j > mark; j--) {
            array[j] = array[j - 1];
        }

        array[mark] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(Object o1, Object o2) {
        insert(new ArrEntry((K) o1, (E) o2));
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            return null;
        }

        Entry<K, E> minEntry = array[n - 1];
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {
            return null;
        }
        return array[n - 1];
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

    public void expandArray() {
        ArrEntry<K, E>[] newArr = new ArrEntry[array.length * 2];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }

    public static void main(String[] args) {
        SortedArrayPriorityQueue priorityQueue = new SortedArrayPriorityQueue<>();

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
