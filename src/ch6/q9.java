package ch6;

import java.util.Scanner;

public class q9 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // N개의 곡
        int N = in.nextInt();
        // M개의 DVD
        int M = in.nextInt();

        int l = Integer.MIN_VALUE;
        int r = 0;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
            if (array[i] > l) {
                l = array[i];
            }
            r += array[i];
        }

        int m;
        int answer = Integer.MAX_VALUE;
        while (l <= r) {
            m = (l + r) / 2;

            int count = 1;
            int size = m;
            for (int i = 0; i < N; i++) {
                if (size >= array[i]) {
                    size -= array[i];
                } else {
                    count += 1;
                    size = m;
                    size -= array[i];
                }
            }

            if (count <= M) {
                answer = Integer.min(answer, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(answer);
    }
}
