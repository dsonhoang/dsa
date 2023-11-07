package Hw3_22001584_DoanSonHoang;

public class FormulaEval {
    public static void main(String[] args) {
        String expr = "( ( 50 - ( ( 8 - 4 ) * ( 2 + 3 ) ) ) + ( 3 * 4 ) )";
        System.out.println(eval(expr));
    }
    public static double eval(String formula)
    {
        String[] chars = formula.split(" ");
        LinkedListStack<Double> digits = new LinkedListStack<>();
        LinkedListStack<String> operators = new LinkedListStack<>();


        for (int i = 0; i < chars.length; i++) {
            if (chars[i].charAt(0) != '(' && chars[i].charAt(0) != ')') {
                if (chars[i].charAt(0) >= '0' && chars[i].charAt(0) <= '9') {
                    digits.push(Double.parseDouble(chars[i]));
                } else {
                    operators.push(chars[i]);
                }
            } else if (chars[i].charAt(0) == ')') {
                double secondDigit = digits.pop();
                double firstDigit = digits.pop();
                String operator = operators.pop();
                double result;

                switch (operator) {
                    case "+":
                        result = firstDigit + secondDigit;
                        break;
                    case "-":
                        result = firstDigit - secondDigit;
                        break;
                    case "*":
                        result = firstDigit * secondDigit;
                        break;
                    case "/":
                        if (secondDigit == 0) {
                            return Double.NEGATIVE_INFINITY;
                        }
                        result = 1.0 * firstDigit / secondDigit;
                        break;
                    default:
                        return Double.NEGATIVE_INFINITY;
                }

                digits.push(result);
            }
        }
        if (digits.isEmpty()) {
            return Double.NEGATIVE_INFINITY;
        } else {
            return digits.pop();
        }
    }
}

