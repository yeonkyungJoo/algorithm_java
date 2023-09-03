package basic.ch8;

import java.util.Scanner;

public class q2 {

    static int C, N;
    static int[] array;
    static int answer = 0;
    static void dfs(int idx, int sum) {

        if (sum > C) {
            return;
        }

        if (idx == N) {
            answer = Integer.max(answer, sum);
            return;
        }

        dfs(idx + 1, sum + array[idx]);
        dfs(idx + 1, sum);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        C = in.nextInt();
        N = in.nextInt();
        array = new int[N];
        int n;
        for (int i = 0; i < N; i++) {
            n = in.nextInt();
            array[i] = n;
        }

        dfs(0, 0);
        System.out.println(answer);
    }
}
