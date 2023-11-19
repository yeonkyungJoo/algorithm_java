package basic_.s1;

import java.util.Scanner;

public class q6 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            String c = Character.toString(charArray[i]);
            if (str.indexOf(c) == i) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
