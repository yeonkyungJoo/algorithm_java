package basic_.s1;

import java.util.Scanner;

public class q4 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            String word = in.next();
            char[] charArray = word.toCharArray();
            int length = word.length();
            for (int j = length - 1; j >= 0; j--) {
                System.out.print(charArray[j]);
            }
            System.out.println();
        }
    }
}
