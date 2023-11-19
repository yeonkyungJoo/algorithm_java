package basic_.s2;

import java.util.Scanner;

public class q4 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] array = new int[N];

        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < N; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }

        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
