package ch8;

import java.util.Scanner;

public class q1 {

    static int N;
    static int[] array;
    static String answer = "NO";
    static void dfs(int idx, int sum, int total) {

        if (idx >= N) {
            if (sum * 2 == total) {
                answer = "YES";
            }
            return;
        }

        dfs(idx + 1, sum + array[idx], total);
        dfs(idx + 1, sum, total);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        array = new int[N];
        int total = 0;
        int n;
        for (int i = 0; i < N; i++) {
            n = in.nextInt();
            array[i] = n;
            total += n;
        }

        dfs(0, 0, total);
        System.out.println(answer);
    }
}
