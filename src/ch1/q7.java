package ch1;

import java.util.Scanner;

public class q7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        str = str.toUpperCase();
        char[] array = str.toCharArray();

        String answer = "YES";
        int lt = 0;
        int rt = array.length - 1;
        while (lt < rt) {
            if (array[lt] != array[rt]) {
                answer = "NO";
                break;
            }
            lt += 1;
            rt -= 1;
        }
        System.out.println(answer);
    }
}
