package LT3_22001584_DoanSonHoang;

import java.util.*;
public class Bai15CodeLearn {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 2; i <= n && i < 10; i++) {
            if (isPrime(i)) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i <= 9; i++) {
                int k = queue.peek() * 10 + i;
                if (k <= n && isPrime(k)) {
                    queue.add(queue.peek() * 10 + i);
                }
            }
            System.out.print(queue.poll() + " ");
        }
    }
}
