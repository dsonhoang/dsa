package LT8_22001584_DoanSonHoang;

import LT2_22001584_DoanSonHoang.DoublyLinkedList;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        SimpleBST<Integer> bst = new SimpleBST<>();

        int[] data = {5, 6, 7, 1, 2, 3, 8, 6, 9, 0};
        for (int i = 0; i < data.length; i++)
            bst.insert(data[i]);
    }
}
