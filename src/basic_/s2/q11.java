package basic_.s2;

import java.util.Scanner;

public class q11 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array = new int[N][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int[][] count = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {

                int cur = array[i][j];
                for (int k = 0; k < N; k++) {

                    if (i == k) {
                        continue;
                    }
                    if (array[k][j] == cur) {
                        count[i][k] = 1;
                    }
                }
            }
        }

        int answer = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += count[i][j];
            }

            if (sum > max) {
                max = sum;
                answer = i;
            }
        }

        System.out.println(answer + 1);
    }
}
