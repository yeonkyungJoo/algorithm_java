package basic.ch1;

import java.util.Scanner;

public class q2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isLowerCase(c)) {
                charArray[i] = Character.toUpperCase(c);
            } else {
                charArray[i] = Character.toLowerCase(c);
            }
        }
        System.out.println(charArray);
    }
}
