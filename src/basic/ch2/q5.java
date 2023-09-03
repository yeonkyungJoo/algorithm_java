package basic.ch2;

import java.util.Scanner;

public class q5 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        array[0] = 1;
        for (int i = 1; i < N; i++) {
            array[i] = array[i-1] + 1;
        }

        array[0] = -1;
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
        for (int n : array) {
            if (n != -1) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
