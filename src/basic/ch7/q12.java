package basic.ch7;

import java.util.Scanner;

public class q12 {

    static int N, M;
    static int[][] array;
    static int[] visited;
    static int count = 0;
    static void dfs(int start) {

        if (start == N) {
            count += 1;
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == 0 && array[start][i] == 1) {
                visited[i] = 1;
                dfs(i);
                visited[i] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        array = new int[N+1][N+1];
        visited = new int[N+1];
        int s, e;
        for (int i = 0; i < M; i++) {
            s = in.nextInt();
            e = in.nextInt();
            array[s][e] = 1;
        }
/*
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }*/

        visited[1] = 1;
        dfs(1);
        System.out.println(count);
    }
}
