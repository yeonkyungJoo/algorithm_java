package basic.ch2;

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

        Integer result = 0;
        // 행/열의 합
        for (int i = 0; i < N; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < N; j++) {
                sum1 += array[i][j];
                sum2 += array[j][i];
            }
            if (sum1 > result) {
                result = sum1;
            }
            if (sum2 > result) {
                result = sum2;
            }
        }

        // 두 대각선의 합
        int sum3 = 0;
        int sum4 = 0;
        for (int i = 0; i < N; i++) {
            sum3 += array[i][i];
            sum4 += array[i][N-i-1];
        }
        if (sum3 > result) {
            result = sum3;
        }
        if (sum4 > result) {
            result = sum4;
        }

        System.out.println(result);
    }
}
