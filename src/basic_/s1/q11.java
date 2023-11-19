package basic_.s1;

import java.util.Scanner;

public class q11 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char[] charArray = str.toCharArray();
        int length = charArray.length;

        StringBuilder sb = new StringBuilder();
        int l = 0;
        while (l < length) {
            char cur = charArray[l];
            int r = l + 1;
            while (r < length) {
                if (cur != charArray[r]) {
                    break;
                }
                r++;
            }
            sb.append(cur);
            if (r - l > 1) {
                sb.append(r - l);
            }

            l = r;
        }

        System.out.println(sb);
    }
}
