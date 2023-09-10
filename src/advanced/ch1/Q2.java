package advanced.ch1;

import java.util.Arrays;

public class Q2 {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        int second = 0;

        // 동, 남, 서, 북
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int curDirection = 0;

        while (second < k) {

            int nextI = answer[0] + di[curDirection % 4];
            int nextJ = answer[1] + dj[curDirection % 4];

            if (((0 <= nextI && nextI < board.length)
                && (0 <= nextJ && nextJ < board.length))
                && board[nextI][nextJ] == 0) {

                answer[0] = nextI;
                answer[1] = nextJ;

            } else {
                // 회전
                curDirection++;
            }
            second++;
        }

        return answer;
    }

    public static void main(String[] args){
        Q2 T = new Q2();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}