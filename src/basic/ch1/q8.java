package basic.ch1;

import java.util.Scanner;

public class q8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = str.toUpperCase();
        char[] array = str.toCharArray();

        String answer = "YES";
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
