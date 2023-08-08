package ch10;

import java.util.Scanner;

public class q3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int[] answer = new int[N];
        answer[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    max = Integer.max(max, answer[j]);
                }
            }
            answer[i] = max + 1;
        }

        int result = Integer.MIN_VALUE;
        for (int n : answer) {
            if (n > result) {
                result = n;
            }
        }
        System.out.println(result);
    }
}
