package ch1;

import java.util.Scanner;

public class q6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if (i == str.indexOf(c)) {
                sb.append(c);
            }
        }
//        HashSet<Character> set = new HashSet<>();
//        for (char c : array) {
//            if (!set.contains(c)) {
//                sb.append(c);
//                set.add(c);
//            }
//        }
        System.out.println(sb);
    }
}
