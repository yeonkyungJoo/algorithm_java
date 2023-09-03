package basic.ch8;

import java.util.Scanner;

public class q4 {

    static int N, M;

    static void dfs(int idx, int[] array) {

        if (idx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            array[idx] = i;
            dfs(idx + 1, array);
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        dfs(0, new int[M]);
    }
}
