package basic_.s2;

import java.util.Scanner;

public class q12 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // 반 학생 수
        int N = in.nextInt();
        // 수학 테스트 수
        int M = in.nextInt();
        int[][] result = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = in.nextInt();
            }
        }

        // 멘토 - 멘티
        int[][] answer = new int[N][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                int n = result[i][j];
                for (int k = j+1; k < N; k++) {
                    int m = result[i][k];
                    answer[n - 1][m - 1] += 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (answer[i][j] == M) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
