package ch8;

import java.util.Scanner;

public class q13 {

    static int[][] array;
    static int N;
    static int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[] {0, -1, -1, -1, 0, 1, 1, 1};

    private static void dfs(int x, int y) {

        array[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && array[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == 1) {
//                    System.out.println("(" + i + ", " + j + ")");
                    answer += 1;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);

    }
}
