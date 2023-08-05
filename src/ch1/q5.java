package ch1;

import java.util.Scanner;

public class q5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] array = str.toCharArray();
        int lt = 0;
        int rt = array.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(array[lt])) {
                lt += 1;
                continue;
            }
            if (!Character.isAlphabetic(array[rt])) {
                rt -= 1;
                continue;
            }
            char tmp = array[lt];
            array[lt] = array[rt];
            array[rt] = tmp;
            lt += 1;
            rt -= 1;
        }
        System.out.println(String.valueOf(array));
    }
}
