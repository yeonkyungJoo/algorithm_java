package basic.ch3;

import java.util.Scanner;

public class q4 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int[] sum = new int[N * 1000];
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            int idx = tmp + array[i];
            sum[idx] = 1;
            tmp = idx;
        }

        int answer = 0;
        int length = sum.length;
        for (int i = M; i < length; i++) {
            if (sum[i] != 1) {
                continue;
            }
            if (sum[i - M] == 1) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
