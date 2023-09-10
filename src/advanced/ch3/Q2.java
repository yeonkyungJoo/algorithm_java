package advanced.ch3;

import java.util.Arrays;
import java.util.Stack;

public class Q2 {
    public String solution(String s){

        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {

            if (c == ')') {

                String tmp = "";
                while (!stack.isEmpty()) {
                    char t = stack.pop();
                    if (t == '(') {
                        break;
                    }
                    tmp = t + tmp;
                }

                int count = 1;
                if (Character.isDigit(stack.peek())) {
                    count = Character.getNumericValue(stack.pop());
                }
                char[] _array = tmp.repeat(count).toCharArray();
                for (char _c : _array) {
                    stack.push(_c);
                }
            } else {
                stack.push(c);

            }
        }

        return stack.toString();
    }

    public static void main(String[] args){
        Q2 T = new Q2();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}