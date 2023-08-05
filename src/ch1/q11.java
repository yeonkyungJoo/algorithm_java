package ch1;

import java.util.Scanner;

public class q11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] array = s.toCharArray();

        String answer = "";
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                count += 1;
            } else {
                answer += array[i-1];
                if (count != 1) {
                    answer += count;
                }
                count = 1;
            }
        }
        answer += array[array.length - 1];
        if (count != 1) {
            answer += count;
        }
        System.out.println(answer);
    }
}
