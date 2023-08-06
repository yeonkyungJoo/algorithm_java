package ch6;

import java.util.Arrays;
import java.util.Scanner;

public class q8 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);

        int l = 0;
        int r = N -1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (array[m] == M) {
                System.out.println(m + 1);
                return;
            } else if (array[m] > M) {
                r = m - 1;
            } else {
                // array[m] < M
                l = m + 1;
            }
        }
    }
}
