package basic_.s2;

import java.util.Scanner;

public class q10 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array = new int[N + 2][N + 2];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int count = 0;
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {

                boolean top = true;
                int cur = array[i][j];
                for (int k = 0; k < 4; k++) {
                    int ni = i + di[k];
                    int nj = j + dj[k];

                    if (array[ni][nj] >= cur) {
                        top = false;
                    }
                }

                if (top) {
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}
