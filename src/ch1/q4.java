package ch1;

import java.util.Scanner;

public class q4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while (N > 0) {
            String str = in.next();
            char[] array = str.toCharArray();
            int lt = 0;
            int rt = array.length - 1;

            while (lt < rt) {
                char tmp = array[lt];
                array[lt] = array[rt];
                array[rt] = tmp;
                lt += 1;
                rt -= 1;
            }

//            String word = new StringBuilder(str).reverse().toString();

//            char[] array = str.toCharArray();
//            String word = "";
//            for (int i = array.length - 1; i >= 0; i--) {
//                word += array[i];
//            }
            System.out.println(String.valueOf(array));
            N--;
        }
    }
}
