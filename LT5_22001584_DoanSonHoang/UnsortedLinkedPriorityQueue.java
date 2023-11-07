package LT5_22001584_DoanSonHoang;
public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            this.next = null;
        }

        public NodeEntry(Entry entry) {
            this.key = (K) entry.getKey();
            this.element = (E) entry.getValue();
            this.next = null;
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
            return "(" + key + ", " + element + ")";
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n = 0;

    public UnsortedLinkedPriorityQueue() {
        head = null;
        tail = null;
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
        NodeEntry<K, E> newEntry = (NodeEntry<K, E>) entry;
        if (head == null) {
            head = newEntry;
            tail = newEntry;
        } else {
            tail.next = newEntry;
            tail = newEntry;
        }
        n++;
    }

    @Override
    public void insert(Object o1, Object o2) {
        NodeEntry newNode = new NodeEntry(o1, o2);
        insert(newNode);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        NodeEntry<K, E> minPrev = null;
        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> prev = null;
        NodeEntry<K, E> current = head;

        while (current != null) {
            if (minNode.getKey().compareTo(current.getKey()) > 0) {
                minPrev = prev;
                minNode = current;
            }
            prev = current;
            current = current.next;
        }

        if (minPrev == null) {
            head = minNode.next;
        } else {
            minPrev.next = minNode.next;
        }

        if (minNode == tail) {
            tail = minPrev;
        }

        minNode.next = null;
        n--;
        return minNode;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        NodeEntry<K, E> minNode = head;
        NodeEntry<K, E> current = head;

        while (current != null) {
            if (minNode.getKey().compareTo(current.getKey()) > 0) {
                minNode = current;
            }
            current = current.next;
        }

        return minNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        NodeEntry<K, E> current = head;
        while (current != null) {
            sb.append(current.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> priorityQueue = new UnsortedLinkedPriorityQueue<>();

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