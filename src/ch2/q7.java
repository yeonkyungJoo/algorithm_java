package ch2;

import java.util.Scanner;

public class q7 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (array[i] == 1) {
                    scores[i] = 1;
                } else {
                    scores[i] = 0;
                }
                continue;
            }

            if (array[i] == 0) {
                scores[i] = 0;
            } else {
                scores[i] = scores[i - 1] + 1;
            }
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        System.out.println(sum);
    }
}
