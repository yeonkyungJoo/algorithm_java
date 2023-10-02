package advanced.ch7;

import java.util.LinkedList;
import java.util.Queue;

public class Q6_ {

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solution(int[][] board){

        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        int r = board.length;
        int c = board[0].length;

        int[][] dist1 = new int[r][c];
        int x = 0;
        int y = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (board[i][j] == 3) {
                    x = i;
                    y = j;
                }

                if (board[i][j] == 2) {

                    Queue<Point> queue = new LinkedList<>();
                    int[][] visited = new int[r][c];

                    queue.add(new Point(i, j));
                    visited[i][j] = 1;
                    int day = 0;

                    while(!queue.isEmpty()) {

                        int size = queue.size();
                        day++;

                        for (int k = 0; k < size; k++) {

                            Point cur = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int ni = cur.i + di[l];
                                int nj = cur.j + dj[l];

                                if (0 <= ni && ni < r
                                        && 0 <= nj && nj < c
                                        && board[ni][nj] != 1
                                        && visited[ni][nj] == 0) {
                                    dist1[ni][nj] = day;
                                    queue.add(new Point(ni, nj));
                                    visited[ni][nj] = 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        int[][] result = new int[r][c];
        result[x][y] = Integer.MAX_VALUE;
        int[][] dist2 = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (board[i][j] == 4) {

                    Queue<Point> queue = new LinkedList<>();
                    int[][] visited = new int[r][c];

                    queue.add(new Point(i, j));
                    visited[i][j] = 1;
                    int day = 0;

                    while(!queue.isEmpty()) {

                        int size = queue.size();
                        day++;

                        for (int k = 0; k < size; k++) {

                            Point cur = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int ni = cur.i + di[l];
                                int nj = cur.j + dj[l];

                                if (0 <= ni && ni < r
                                        && 0 <= nj && nj < c
                                        && board[ni][nj] != 1
                                        && visited[ni][nj] == 0) {

                                    dist2[ni][nj] = day;
                                    queue.add(new Point(ni, nj));
                                    visited[ni][nj] = 1;
                                }
                            }
                        }
                    }

                    result[x][y] = Integer.min(result[x][y], dist1[i][j] + dist2[x][y]);
                }
            }
        }
        return result[x][y];
    }

    public static void main(String[] args){
        Q6_ T = new Q6_();
        System.out.println(T.solution(new int[][]{{4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{{4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}
