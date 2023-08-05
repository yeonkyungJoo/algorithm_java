package ch1;

import java.util.Scanner;

public class q3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] array = str.split(" ");
        int count = 0;
        String longest = null;
        for (String s : array) {
            String word = s.trim();
            if (word.length() > count) {
                count = word.length();
                longest = word;
            }
        }
        System.out.println(longest);
    }
}
