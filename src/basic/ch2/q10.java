package basic.ch2;

import java.util.Scanner;

public class q10 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array = new int[N+2][N+2];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int count = 0;
        int[] dr = new int[] {-1, 0, 1, 0};
        int[] dc = new int[] {0, 1, 0, -1};
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                boolean result = true;
                int n = array[i][j];

                for (int k = 0; k < 4; k++) {
                    int _i = dr[k] + i;
                    int _j = dc[k] + j;
                    if (n <= array[_i][_j]) {
                        result = false;
                        break;
                    }
                }

                if (result) {
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
