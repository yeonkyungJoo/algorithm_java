package basic.ch1;

import java.util.Scanner;

public class q9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        str = str.replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(str));
    }
}
