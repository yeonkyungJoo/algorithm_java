package basic_.s1;

import java.util.Locale;
import java.util.Scanner;

public class q1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);

        int count = 0;
        str = str.toUpperCase(Locale.ROOT);
        c = Character.toUpperCase(c);
        for (char x : str.toCharArray()) {
            if (x == c) {
                count++;
            }
        }

        System.out.println(count);
    }
}
