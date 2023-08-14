package ch8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q12 {

    static int[][] array;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = in.nextInt();
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {

            while (!queue.isEmpty()) {

                Point point = queue.poll();
                int x = point.x;
                int y = point.y;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M) && array[nx][ny] == 0) {
                        array[nx][ny] = array[x][y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }

            int answer = Integer.MIN_VALUE;
            boolean result = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (array[i][j] == -1) {
                        continue;
                    }

                    if (array[i][j] == 0) {
                        result = false;
                    }
                    answer = Integer.max(answer, array[i][j]);
                }
            }

            if (result) {
                System.out.println(answer - 1);
            } else {
                System.out.println(-1);
            }

        }

    }
}
