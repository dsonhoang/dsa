package OnTap;

import java.util.List;

public interface LinkedBinarySearchTreeInterface<E extends Comparable<E>> {
    E root();
    E parent(E p);
    E left(E p);
    E right(E p);
    E sibling(E p);
    E findMax();
    E findMin();
    void insert(E element);
    void delete(E element);
    boolean search(E element);
    int size();
    boolean isEmpty();
    void clear();
    int numChildren(E p);
}