package basic_.s1;

import java.util.Scanner;

public class q9 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        Integer answer = Integer.parseInt(sb.toString());
        System.out.println(answer);
    }
}
