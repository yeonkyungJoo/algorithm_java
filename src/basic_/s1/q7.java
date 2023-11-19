package basic_.s1;

import java.util.Scanner;

public class q7 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();

        int l = 0;
        int r = charArray.length - 1;
        while (l <= r) {
            char left = Character.toUpperCase(charArray[l]);
            char right = Character.toUpperCase(charArray[r]);
            if (left != right) {
                System.out.println("NO");
                return;
            }
            l++;
            r--;
        }
        System.out.println("YES");
    }
}
