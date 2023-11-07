package LT8_22001584_DoanSonHoang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class SimpleBST<Key extends Comparable<Key>> implements SimpleBTreeInterface<Key> {
    class Node{
        Key data;
        Node left, right;
        public Node(Key key)
        {
            this.data = key;
            this.left = null;
            this.right = null;
        }
    }

    private Node root = null;
    int n = 0;
    @Override
    public void insert(Key k) {
        // TODO Auto-generated method stub
        if(root == null){
            root = new Node(k);
        }
        else insert(root, k);
        n++;
    }

    public Node insert(Node currentNode, Key value) {
        if (currentNode == null) {
            return new Node(value);
        }
        else {
            int compare = value.compareTo(currentNode.data);

            if (compare < 0) {
                currentNode.left = insert(currentNode.left, value);
            } else if (compare > 0) {
                currentNode.right = insert(currentNode.right, value);
            }
        }
        return currentNode;
    }

    @Override
    public Key search(Key k) {
        // TODO Auto-generated method stub

        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub

        return null;
    }

    //duyệt cây theo thứ tự trước (tiền thứ tự)
    public void preTraverse()
    {

    }

    // duyệt cây theo thứ tự sau (hậu thứ tự)
    public void postTraverse() {

    }

    // duyệt cây theo thứ tự giữa (trung thứ tự)
    public void inTraverse() {

    }
}
