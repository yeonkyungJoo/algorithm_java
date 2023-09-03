package basic.ch5;

import java.util.Scanner;
import java.util.Stack;

public class q1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] array = s.toCharArray();

        int length = array.length;
        if (length == 0) {
            System.out.println("YES");
            return;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = array[i];

            if (!stack.isEmpty()) {
                char last = stack.peek();
                if ('(' == last && ')' == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
