package basic_.s1;

import java.util.Scanner;

public class q5 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();

        int l = 0;
        int r = charArray.length - 1;
        while (l <= r) {

            if (!Character.isAlphabetic(charArray[l])) {
                l++;
                continue;
            }
            if (!Character.isAlphabetic(charArray[r])) {
                r--;
                continue;
            }

            char tmp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = tmp;
            l++;
            r--;
        }

        System.out.println(charArray);
    }
}
