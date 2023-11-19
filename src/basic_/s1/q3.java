package basic_.s1;

import java.util.Scanner;

public class q3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] words = str.split(" ");
        int maxLength = -1;
        String answer = null;
        for (String word : words) {
            word = word.trim();
            if (word.length() > maxLength) {
                answer = word;
                maxLength = word.length();
            }
        }

        System.out.println(answer);
    }
}
