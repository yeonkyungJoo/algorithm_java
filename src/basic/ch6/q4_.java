package basic.ch6;

import java.util.Arrays;
import java.util.Scanner;

public class q4_ {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int S = in.nextInt();
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        int[] check = new int[1001];
        Arrays.fill(check, -1);
        int[] cache = new int[S];
        for (int i = 0; i < N; i++) {
            int n = array[i];
            int startIdx;
            if (check[n] >= 0) {
                startIdx = check[n];
            } else {
                startIdx = S - 1;
                check[cache[S - 1]] = -1;
            }

            for (int j = startIdx; j > 0; j--) {
                cache[j] = cache[j-1];
                check[cache[j]] += 1;
            }
            cache[0] = n;
            check[n] = 0;
        }

        for (int n: cache) {
            System.out.print(n + " ");
        }

    }
}
