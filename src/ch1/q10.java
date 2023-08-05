package ch1;

import java.util.Scanner;

public class q10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char t = in.next().charAt(0);

        char[] array = s.toCharArray();
        int[] answer = new int[array.length];
        // 앞에서부터
        int dist = 1000;
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == t) {
                dist = 0;
            } else {
                dist += 1;
            }
            answer[i] = dist;
        }

        // 뒤에서부터
        for (int i = array.length - 1; i >= 0; i--) {
            char c = array[i];
            if (c == t) {
                dist = 0;
            } else {
                dist += 1;
            }
            answer[i] = Integer.min(answer[i], dist);
        }

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
