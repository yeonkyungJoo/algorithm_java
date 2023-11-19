package basic_.s2;

import java.util.Scanner;

public class q9 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;

        // 각 행의 합
        // 각 열의 합
        for (int i = 0; i < N; i++) {
            int rowTotal = 0;
            int colTotal = 0;
            for (int j = 0; j < N; j++) {
                rowTotal += array[i][j];
                colTotal += array[j][i];
            }
            max = Integer.max(max, rowTotal);
            max = Integer.max(max, colTotal);
        }

        // 두 대각선의 합
        int rightDownTotal = 0;
        int rightUpTotal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    rightDownTotal += array[j][i];
                }
                if (i == N - 1 - j) {
                    rightUpTotal += array[i][j];
                }
            }
            max = Integer.max(max, rightDownTotal);
            max = Integer.max(max, rightUpTotal);
        }

        System.out.println(max);
    }
}
