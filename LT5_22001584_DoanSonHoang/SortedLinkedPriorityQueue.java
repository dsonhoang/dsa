package LT5_22001584_DoanSonHoang;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            key = k;
            element = e;
            next = null;
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
    private int n = 0;

    public SortedLinkedPriorityQueue() {
        head = null;
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
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> newEntry = (NodeEntry<K, E>) entry;

        if (isEmpty() || entry.getKey().compareTo(head.getKey()) < 0) {
            newEntry.next = head;
            head = newEntry;
        } else {
            NodeEntry<K, E> current = head;
            while (current.next != null && entry.getKey().compareTo(current.next.getKey()) >= 0) {
                current = current.next;
            }
            newEntry.next = current.next;
            current.next = newEntry;
        }

        n++;
    }

    @Override
    public void insert(K o1, E o2) {
        NodeEntry newNode = new NodeEntry(o1, o2);
        insert(newNode);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        NodeEntry<K, E> removedEntry = head;
        head = head.next;
        removedEntry.next = null;
        n--;

        return removedEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        return head;
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
        SortedLinkedPriorityQueue<Integer, String> priorityQueue = new SortedLinkedPriorityQueue<>();

        priorityQueue.insert(3, "this");
        priorityQueue.insert(1, "is");
        priorityQueue.insert(2, "an");
        priorityQueue.insert(4, "apple");

        // Print the size of the priority queue
        System.out.println("Size: " + priorityQueue.size());

        // Get and print the minimum entry
        Entry<Integer, String> minEntry = priorityQueue.min();
        System.out.println("Min Entry: Key=" + minEntry.getKey() + ", Value=" + minEntry.getValue());

        // Remove the minimum entry
        Entry<Integer, String> removedEntry = priorityQueue.removeMin();
        System.out.println("Removed Entry: Key=" + removedEntry.getKey() + ", Value=" + removedEntry.getValue());

        // Print the size of the priority queue after removal
        System.out.println("Size after removal: " + priorityQueue.size());
        System.out.println(priorityQueue);
    }
}