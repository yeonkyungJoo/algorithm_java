package basic.ch2;

import java.util.Scanner;

public class q12 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] array = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();
            }
        }


        int[][] answer = new int[N][N];
        for (int i = 0; i < M; i++) {

            for (int j = 1; j < N; j++) {
                int n = array[i][j];

                for (int k = 0; k < j; k++) {
                    int m = array[i][k];
                    answer[n-1][m-1] = -1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (answer[i][j] == 0) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
