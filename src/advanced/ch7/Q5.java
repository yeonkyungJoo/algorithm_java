package advanced.ch7;

import java.util.LinkedList;
import java.util.Queue;

public class Q5 {

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

        int n = board.length;
        int[][] dist = new int[n][n];
        int[][] visitedCount = new int[n][n];
        int buildingCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == 1) {
                    buildingCount++;

                    Queue<Point> queue = new LinkedList<>();
                    int[][] visited = new int[n][n];

                    queue.add(new Point(i, j));
                    visited[i][j] = 1;
                    int count = 0;
                    while (!queue.isEmpty()) {

                        int size = queue.size();
                        count++;
                        for (int k = 0; k < size; k++) {

                            Point cur = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int ni = cur.i + di[l];
                                int nj = cur.j + dj[l];

                                if (0 <= ni && ni < n
                                        && 0 <= nj && nj < n
                                        && board[ni][nj] == 0
                                        && visited[ni][nj] == 0) {
                                    dist[ni][nj] += count;
                                    queue.add(new Point(ni, nj));
                                    visited[ni][nj] = 1;
                                    visitedCount[ni][nj] += 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (visitedCount[i][j] == buildingCount
                        && dist[i][j] != 0) {
                    answer = Integer.min(answer, dist[i][j]);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        Q5 T = new Q5();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}
