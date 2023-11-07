package LT3_22001584_DoanSonHoang;

import java.util.*;
public class Bai16Codelearn {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isUnique = new boolean[1001];
        int[] inputArray = new int[1001];

        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();

        for (int i = 0; i < 1001; i++) {
            isUnique[i] = false;
        }

        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = scanner.nextInt();
        }

        int maxSize = scanner.nextInt();
        scanner.close();

        for (int i = 0; i < arraySize; i++) {
            int currentElement = inputArray[i];
            if (!isUnique[currentElement]) {
                if (queue.size() < maxSize) {
                    isUnique[currentElement] = true;
                    queue.add(currentElement);
                } else {
                    int removedElement = queue.poll();
                    isUnique[removedElement] = false;
                    isUnique[currentElement] = true;
                    queue.add(currentElement);
                }
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
