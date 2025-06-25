import java.util.*;

public class infixToPostfix{

    // Operator precedence map
    private static int precedence(char op) {
        switch (op) {
            case '^': return 3;
            case '*': case '/': case '%': return 2;
            case '+': case '-': return 1;
            default: return 0;
        }
    }

    // Check if character is an operator
    private static boolean isOperator(char ch) {
         switch (ch) {
        case '+': case '-': case '*': case '/': case '%': case '^':
            return true;
        default:
            return false;
        }
    }

    // Check if character is alphanumeric (operand)
    private static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    // Infix to Postfix conversion
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // Skip spaces
            if (ch == ' ') continue;

            if (isOperand(ch)) {
                postfix.append(ch);
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // discard '('
                } else {
                    return "Error: Mismatched parentheses";
                }
            }
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    if (ch == '^' && stack.peek() == '^') break; // right-associative ^ operator
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == ')') {
                return "Error: Mismatched parentheses";
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Main method to test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);
    }
}