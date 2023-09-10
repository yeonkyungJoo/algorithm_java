package advanced.ch1;

import java.util.Arrays;

public class Q4 {

    // c(j) : 가로, r(i) : 세로
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        if (c * r < k) {
            return new int[]{0, 0};
        }

        // 북, 동, 남, 서
        int[] di = new int[]{-1, 0, 1, 0};
        int[] dj = new int[]{0, 1, 0, -1};
        int directionIdx = 0;
        int[][] board = new int[r][c];

        int i = r - 1;
        int j = 0;
        board[i][j] = 1;

        int n = 1;
        while (n < k) {

            int ni = i + di[directionIdx % 4];
            int nj = j + dj[directionIdx % 4];
            if ((ni >= 0 && ni < r) && (nj >= 0 && nj < c)) {

                if (board[ni][nj] == 0) {
                    i = ni;
                    j = nj;
                    board[i][j] = 1;
                    n++;

                } else {
                    directionIdx++;
                }
            } else {
                directionIdx++;
            }
        }

        return new int[]{j + 1, r - i};
    }

    public static void main(String[] args){
        Q4 T = new Q4();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
