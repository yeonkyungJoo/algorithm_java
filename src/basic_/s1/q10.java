package basic_.s1;

import java.util.Arrays;
import java.util.Scanner;

public class q10 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char t = in.next().charAt(0);

        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int[] answer = new int[length];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int i = 0; i < length; i++) {

            if (charArray[i] == t) {
                for (int j = 0; j < length; j++) {
                    answer[j] = Math.min(answer[j], Math.abs(i - j));
                }
            }
        }

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }
}
