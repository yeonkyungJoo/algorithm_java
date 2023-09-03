package basic.ch2;

import java.util.Scanner;

public class q11 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();
            }
        }


        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                int n = array[i][j];
                for (int k = 0; k < N; k++) {
                    if (k == i) {
                        continue;
                    }

                    if (n == array[k][j]) {
                        answer[i][k] = 1;
                    }
                }
            }
        }

        int result = 1;
        int max = 0;
        for (int j = 0; j < N; j++) {
            max += answer[0][j];
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += answer[i][j];
            }

            if (sum > max) {
                max = sum;
                result = i + 1;
            }
        }
        System.out.println(result);
    }
}
