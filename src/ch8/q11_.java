package ch8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q11_ {

    static int[][] array;

    static int[][] visited;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, -1, 0, 1};

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
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

        boolean exist = false;
        int answer = Integer.MAX_VALUE;

        visited = new int[8][8];
        Queue<Point> queue = new LinkedList<>();
        visited[1][1] = 1;
        queue.offer(new Point(1, 1, 0));

        while (!queue.isEmpty()) {

            Point point = queue.poll();
            assert point != null;
            int x = point.x;
            int y = point.y;
            int count = point.count;

            if (x == 7 && y == 7) {
                answer = Integer.min(answer, count);
                exist = true;
                break;
            }

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if ((nx >= 1 && nx <= 7)
                        && (ny >= 1 && ny <= 7)
                        && array[nx][ny] == 0
                        && visited[nx][ny] == 0) {

                    visited[nx][ny] = 1;
                    queue.offer(new Point(nx, ny, count + 1));
                }
            }
        }


        if (!exist) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
