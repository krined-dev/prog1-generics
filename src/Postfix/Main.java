package Postfix;

public class Main {
    public static void main(String[] args) throws Exception {
        String expression = "2 2 6 6 / * +";
        PostfixEvaluator eval = new PostfixEvaluator();

        System.out.println(eval.evaluateExpression(expression));
    }
}
