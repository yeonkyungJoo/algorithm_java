package ch8;

import java.util.Scanner;

public class q10 {

    static int[][] array;

    static int[][] ch;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};
    static int count = 0;
    static void dfs(int x, int y) {

        if (x == 7 && y == 7) {
            count += 1;
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((nx >= 1 && nx <= 7)
                    && (ny >= 1 && ny <= 7)
                    && array[nx][ny] == 0
                    && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                dfs(nx, ny);
                ch[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        array = new int[8][8];
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                array[i][j] = in.nextInt();
            }
        }

        ch = new int[8][8];
        ch[1][1] = 1;
        dfs(1, 1);
        System.out.println(count);
    }
}
