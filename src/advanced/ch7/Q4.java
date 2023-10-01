package advanced.ch7;

import java.util.LinkedList;
import java.util.Queue;

public class Q4 {

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

        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[7][7];

        queue.add(new Point(0, 0));
        visited[0][0] = 1;
        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Point cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int ni = cur.i + di[k];
                    int nj = cur.j + dj[k];

                    if (0 <= ni && ni < 7
                            && 0 <= nj && nj < 7
                            && board[ni][nj] == 0
                            && visited[ni][nj] == 0) {

                        if (ni == 6 && nj == 6) {
                            return count + 1;
                        }

                        visited[ni][nj] = 1;
                        queue.add(new Point(ni, nj));
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] arr1 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(new Q4().solution(arr1));

        int[][] arr2 = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};
        System.out.println(new Q4().solution(arr2));
    }
}
