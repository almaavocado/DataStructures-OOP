import java.util.Scanner;
public class StackBal {

    NodeChar top;
    int Size = 0;
    void push(char value) {
        NodeChar n = new NodeChar(value);
        if (top != null) {
            n.next = top;
            top = n;
        }
        else {
            top = n;
        }
    }
    char pop() {
        char temp = top.data;
        top = top.next;
        Size--;
        return temp;
    }
    boolean isBalanced(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {
                push(expression.charAt(i));
                Size++;
            } else if (expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']') {
                if (Size == 0) {
                    return false;
                }
                if (expression.charAt(i) == ')') {
                    if (pop() != '(') {
                        return false;
                    }
                }
                if (expression.charAt(i) == '}') {
                    if (pop() != '{') {
                        return false;
                    }
                }
                if (expression.charAt(i) == ']') {
                    if (pop() != '[') {
                        return false;
                    }
                }
            }
        }
        if (Size > 0) {
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        StackBal Stack = new StackBal();
        String userIn = scnr.nextLine();
        System.out.println(Stack.isBalanced(userIn));

        String first_input = "(3+4*[12/87])";
        System.out.println(Stack.isBalanced(first_input));

        String second_input = "(3*[12/87]+2)/54]";
        System.out.println(Stack.isBalanced(second_input));
    }
}