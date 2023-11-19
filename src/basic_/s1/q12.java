package basic_.s1;

import java.util.Scanner;

public class q12 {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        char[] charArray = str.toCharArray();

        int length = charArray.length;
        for (int i = 0; i < length; i += 7) {

            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + 7; j++) {
                if (charArray[j] == '#') {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }

            sb.reverse();
            char c = 0;
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '1') {
                    c += Math.pow(2, j);
                }
            }
            System.out.print(c);
        }
    }
}
