package LT3_22001584_DoanSonHoang;

import java.util.*;
public class Bai14Codelearn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int element = sc.nextInt();
            queue.offer(element);
        }

        int k = sc.nextInt();
        sc.close();
        for (int i = 0; i < k; i++) {
            int value = queue.poll();
            queue.offer(value);
        }

        for (Integer element : queue) {
            System.out.print(element + " ");
        }
    }
}
