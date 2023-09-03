package basic.ch5;

import java.util.Scanner;
import java.util.Stack;

public class q2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] array = s.toCharArray();

        int length = array.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = array[i];
            if (')' == c) {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        for (char c : stack) {
            System.out.print(c);
        }
    }
}
