package LT6_22001584_DoanSonHoang;

import java.util.Stack;

public class ExpressionTree<E> extends LinkedBinaryTree<E, String> {
    // Constructor to create an ExpressionTree with an empty root
    public ExpressionTree() {
        super();
    }

    // Method to convert the expression tree to an infix expression
    public String toInfixExpression() {
        return toInfixExpression(root);
    }

    private String toInfixExpression(Node<E> node) {
        if (node == null) {
            return "";
        }

        String left = toInfixExpression(node.getLeft());
        String right = toInfixExpression(node.getRight());

        if (isOperator(node.getElement().toString())) {
            return "(" + left + " " + node.getElement() + " " + right + ")";
        } else {
            return node.getElement().toString();
        }
    }

    // Method to convert the expression tree to a postfix expression
    public String toPostfixExpression() {
        return toPostfixExpression(root);
    }

    private String toPostfixExpression(Node<E> node) {
        if (node == null) {
            return "";
        }

        String left = toPostfixExpression(node.getLeft());
        String right = toPostfixExpression(node.getRight());

        if (isOperator(node.getElement().toString())) {
            return left + " " + right + " " + node.getElement();
        } else {
            return node.getElement().toString();
        }
    }

    // Method to convert the expression tree to a prefix expression
    public String toPrefixExpression() {
        return toPrefixExpression(root);
    }

    private String toPrefixExpression(Node<E> node) {
        if (node == null) {
            return "";
        }

        String left = toPrefixExpression(node.getLeft());
        String right = toPrefixExpression(node.getRight());

        if (isOperator(node.getElement().toString())) {
            return node.getElement() + " " + left + " " + right;
        } else {
            return node.getElement().toString();
        }
    }

    // Method to evaluate the expression tree
    public double evaluateExpression() {
        return evaluateExpression(root);
    }

    private double evaluateExpression(Node<E> node) {
        if (node == null) {
            return 0.0;
        }

        if (isOperator(node.getElement().toString())) {
            double left = evaluateExpression(node.getLeft());
            double right = evaluateExpression(node.getRight());
            return applyOperator(node.getElement().toString(), left, right);
        } else {
            return Double.parseDouble(node.getElement().toString());
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private double applyOperator(String operator, double left, double right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                if (right != 0) {
                    return left / right;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        LinkedBinaryTree linkedTree = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> root = linkedTree.addRoot(1);
        linkedTree.addLeft(root, 5);
        linkedTree.addRight(root, 3);
        linkedTree.addLeft(root.getLeft(), 8);
        linkedTree.addRight(root.getLeft(), 6);
        linkedTree.addLeft(root.getRight(), 2);
        linkedTree.addRight(root.getRight(), 7);
    }
}