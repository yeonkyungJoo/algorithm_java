package basic.ch6;

import java.util.Arrays;
import java.util.Scanner;

public class q5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        String result = "U";
        Arrays.sort(array);

        for (int i = 0; i < N-1; i++) {
            if (array[i] == array[i+1]) {
                result = "D";
                break;
            }
        }
        System.out.println(result);
    }
}
