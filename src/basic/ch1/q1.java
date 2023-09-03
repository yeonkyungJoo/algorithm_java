package basic.ch1;

import java.util.Scanner;

public class q1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);

        int count = 0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);
        for (char x : str.toCharArray()) {
            if (c == x) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
