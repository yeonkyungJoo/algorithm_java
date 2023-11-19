package basic_.s2;

import java.util.Scanner;

public class q1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = in.nextInt();
        }

        System.out.print(array[0] + " ");
        for (int i = 1; i < N; i++) {
            if (array[i - 1] < array[i]) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
