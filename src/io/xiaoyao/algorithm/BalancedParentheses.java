package io.xiaoyao.algorithm;

import java.util.Stack;

/**
 * @author Jason Xiao
 * @date 2019/10/15
 */
public class BalancedParentheses {

    public static boolean isBalanced(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
                if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                }
                if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                    continue;
                }
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String p = "(({{}}))";
        String p1 = "{{[[(())]]}}}";
        String p2 = "{{[[[](())]][]}}";
        System.out.println(isBalanced(p));
        System.out.println(isBalanced(p1));
        System.out.println(isBalanced(p2));
    }
}
