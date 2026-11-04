package assignment;

public class Expression implements ExpressionEvaluatorInterface {


    @Override
    public String infixToPostfix(String infix) {

        Stack operators = new Stack();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            if (ch == ' ') {
                continue;
            }

            // number
            if (Character.isDigit(ch)) {

                while (i < infix.length()
                        && Character.isDigit(infix.charAt(i))) {
                    postfix.append(infix.charAt(i));
                    i++;
                }

                postfix.append(" ");
                i--;
            }

            // left parenthesis
            else if (ch == '(') {
                operators.push(ch);
            }

            // right parenthesis
            else if (ch == ')') {

                while (!operators.isEmpty()
                        && (char)((Node)operators.peek()).value != '(') {

                    postfix.append(
                        ((Node)operators.pop()).value
                    ).append(" ");
                }

                if (!operators.isEmpty()) {
                    operators.pop(); // remove (
                }
            }

            // operator
            else {

                while (!operators.isEmpty()
                        && precedence(
                                (char)((Node)operators.peek()).value)
                           >= precedence(ch)
                        && (char)((Node)operators.peek()).value != '(') {

                    postfix.append(
                        ((Node)operators.pop()).value
                    ).append(" ");
                }

                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            postfix.append(
                ((Node)operators.pop()).value
            ).append(" ");
        }

        return postfix.toString().trim();
    }

    @Override
    public int evaluatePostfix(String postfix) {

        Stack values = new Stack();

        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {

            if (Character.isDigit(token.charAt(0))) {

                values.push(Integer.parseInt(token));
            }
            else {

                int b = (int)((Node)values.pop()).value;
                int a = (int)((Node)values.pop()).value;

                switch (token.charAt(0)) {

                    case '+':
                        values.push(a + b);
                        break;

                    case '-':
                        values.push(a - b);
                        break;

                    case '*':
                        values.push(a * b);
                        break;

                    case '/':
                        values.push(a / b);
                        break;
                }
            }
        }

        return (int)((Node)values.pop()).value;
    }

    private int precedence(char op) {

        switch (op) {

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            default:
                return 0;
        }
    }
}