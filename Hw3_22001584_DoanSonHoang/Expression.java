package Hw3_22001584_DoanSonHoang;

import java.util.*;
public class Expression{

    public boolean isValidExpr(String expr)
    {
        Stack<String> myStack = new Stack<>();
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') {
                myStack.push("" + expr.charAt(i));
            } else if (expr.charAt(i) == ')') {
                if (myStack.empty()) {
                    return false;
                } else {
                    myStack.pop();
                }
            }
        }

        if (!myStack.empty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args)
    {

        Expression expr = new Expression();
        String f = "a+b-c(3+a)";
        System.out.println(expr.isValidExpr(f));

    }
}