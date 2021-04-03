package Postfix;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PostfixEvaluator {
    private ArrayDeque<Integer> stack;

    PostfixEvaluator() {
        stack = new ArrayDeque<>();
    }

    public int evaluateExpression(String expression) throws Exception {
        if (!(validExpression(expression))) {
           throw new Exception("This is not a valid expression");
        };
        scanAndProcessTokens(expression);

        if (stack.peek() == null) {
            throw new Exception("Invalid expression");
        }

        return stack.peek();
     }

    private void scanAndProcessTokens(String expression) {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(expression, " +-/*%", true);
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (isOperator(token)) {
                if (canOperate()) {
                    applyOperator(token);
                } else {
                    System.out.println("Not enough operands to perform calculations on postfix notation.");
                    System.exit(1);
                }
            } else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (Exception ignore) {}
            }
        }
    }

    private void applyOperator(String operator) {

        int two = stack.pop();
        int one = stack.pop();

        switch(operator) {
            case "*":
                stack.push(one * two);
                break;
            case "+":
                stack.push(one + two);
                break;
            case "-":
                stack.push(one - two);
                break;
            case "/":
                    stack.push(one / two);

            case " ":
                break;
        }
    }

    private boolean isOperator(String s){
        ArrayList<String> operators = new ArrayList<>(){{
            add("*");
            add("+");
            add("-");
            add("/");
            add(" ");
        }};

        return (operators.contains(s));
    }

    private boolean isPositiveInteger(String s){
        try {
            int i = Integer.parseInt(s);
            return i >= 0;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validExpression(String s) {
        boolean flag = true;
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(s, " +-/*%", true);
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if (!(isPositiveInteger(token)) && !(isOperator(token))) {
                flag = false;
            }
        }

        return flag;
    }

    public boolean canOperate() {
        if (stack.size() > 1) {
            return true;
        }
        return false;
    }
}
