package ch1;

import java.util.Scanner;

public class q12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String s = in.next();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (c == '#') {
                array[i] = '1';
            } else {
                array[i] = '0';
            }
        }

        String answer = "";
        for (int j = 0; j < N; j++) {
            int start = j * 7;
            int end = start + 7 - 1;

            int n = 1;
            int num = 0;
            for (int i = end; i >= start; i--) {
                char c = array[i];
                if (c == '1') {
                    num += n;
                }
                n *= 2;
            }
            answer += (char) num;
        }

        System.out.println(answer);
    }
}
