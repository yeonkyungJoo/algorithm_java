package basic.ch10;

import java.util.Arrays;
import java.util.Scanner;

public class q5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        int M = in.nextInt();

        int[] answer = new int[M+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[0] = 0;
        for (int j = 0; j < N; j++) {
            for (int i = array[j]; i < M + 1; i++) {
                answer[i] = Integer.min(answer[i], answer[i - array[j]] + 1);
            }
        }

        System.out.println(answer[M]);
    }
}
