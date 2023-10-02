package advanced.ch4;

import java.util.ArrayList;
import java.util.List;

public class Q5_ {

//    public int solution(int[][] board){
//        int answer = 0;
//
//        int n = board.length;
//        int[][] dist = new int[n][n];
//
//        int[] di = new int[]{-1, 0, 1, 0};
//        int[] dj = new int[]{0, -1, 0, 1};
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//
//                if (board[i][j] == 1) {
//
//                    Queue<int[]> queue = new LinkedList<>();
//                    int[][] visited = new int[n][n];
//                    queue.add(new int[]{i, j});
//                    visited[i][j] = 1;
//
//                    int count = 0;
//                    while (!queue.isEmpty()) {
//
//                        int size = queue.size();
//                        count++;
//                        for (int k = 0; k < size; k++) {
//
//                            int[] cur = queue.poll();
//
//                            for (int l = 0; l < 4; l++) {
//                                int ni = cur[0] + di[l];
//                                int nj = cur[1] + dj[l];
//
//                                if (0 <= ni && ni < n
//                                && 0 <= nj && nj < n
//                                && visited[ni][nj] == 0) {
//                                    visited[ni][nj] = 1;
//                                    queue.add(new int[]{ni, nj});
//                                    dist[ni][nj] += count;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        answer = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                answer = Integer.min(answer, dist[i][j]);
//            }
//        }
//
//        return answer;
//    }
    public int solution(int[][] board){
        int answer = 0;

        int n = board.length;
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        row.sort(Integer::compareTo);
        col.sort(Integer::compareTo);

        int i = row.get(row.size() / 2);
        int j = col.get(col.size() / 2);

        answer += row.stream().map(num -> Math.abs(num - i)).reduce(Integer::sum).get();
        answer += col.stream().map(num -> Math.abs(num - j)).reduce(Integer::sum).get();

        return answer;
    }

    public static void main(String[] args){
        System.out.println(new Q5_().solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(new Q5_().solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(new Q5_().solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
