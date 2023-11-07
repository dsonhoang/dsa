package LT3_22001584_DoanSonHoang;
import java.util.*;

public class Bai13Codelearn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        String input = sc.nextLine();
        String output = "";

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty() || stack.peek() == input.charAt(i)) {
                stack.push(input.charAt(i));
                count++;
            } else if (stack.peek() != input.charAt(i)) {
                output += stack.peek() + Integer.toString(count);
                count = 1;
                stack.push(input.charAt(i));
            }
        }

        output += stack.peek() + Integer.toString(count);

        System.out.println(output);
    }
}
