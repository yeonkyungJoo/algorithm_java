package basic_.s2;

import java.util.Scanner;

public class q5 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i + 1;
        }

        for (int i = 1; i < N; i++) {
            int n = array[i];
            if (n == -1) {
                continue;
            }

            for (int j = i + n; j < N; j += n) {
                array[j] = -1;
            }
        }

        int count = 0;
        for (int i = 1; i < N; i++) {
            if (array[i] != -1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
