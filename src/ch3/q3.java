package ch3;

import java.util.Scanner;

public class q3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int[] sum = new int[N+1];
        sum[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            sum[i] = array[i-1] + sum[i-1];
        }

        int answer = 0;
        for (int i = K; i < N + 1; i++) {
            int tmp = sum[i] - sum[i-K];
            if (answer < tmp) {
                answer = tmp;
            }
        }
        System.out.println(answer);
    }
}
