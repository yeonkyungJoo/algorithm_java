package ch7;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class q2 {

    public static String recursive(int N) {

        if (N <= 0) {
            return "";
        }
        return recursive(N / 2) + (N % 2);
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        System.out.println(recursive(N));
    }
}
