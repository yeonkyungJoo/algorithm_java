package basic.ch6;

import java.util.Arrays;
import java.util.Scanner;

public class q10 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int C = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        int min = array[0];
        int max = array[N - 1];

        int l = array[1] - array[0];
        int r = array[N - 1] - array[0];


        int m;
        int answer = Integer.MIN_VALUE;
        while (l <= r) {
            m = (l + r) / 2;

            int count = 1;
            int cur = 0;
            for (int i = 1; i < N; i++) {
                if (array[i] - array[cur] >= m) {
                    count += 1;
                    cur = i;
                }
            }

            if (count < C) {
                r = m - 1;
            } else {
                l = m + 1;
                answer = Integer.max(answer, m);
            }
        }
        System.out.println(answer);
    }
}
