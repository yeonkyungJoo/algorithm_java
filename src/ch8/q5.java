package ch8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class q5 {

    static int N, M;
    static Integer[] coins;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int idx, int total, int count) {

        if (total == M) {
            answer = Integer.min(answer, count);
        }


        for (int i = 0; i < N; i++) {
            if (total + coins[i] <= M) {

                if (count + 1 >= answer) {
                    continue;
                }

                dfs(idx + 1, total + coins[i], count + 1);
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        coins = new Integer[N];
        for (int i = 0; i < N; i++) {
            coins[i] = in.nextInt();
        }
        M = in.nextInt();

        Arrays.sort(coins, Collections.reverseOrder());
        dfs(0, 0, 0);
        System.out.println(answer);
    }
}
