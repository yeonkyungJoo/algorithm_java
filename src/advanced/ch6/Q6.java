package advanced.ch6;

import java.util.HashSet;
import java.util.Set;

public class Q6 {

    private String s;
    private Set<String> answer = new HashSet<>();

    private void dfs(int startIndex, String str) {

        if (startIndex >= s.length()) {
//            System.out.print(str + " ");
            answer.add(str);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int exclusiveEndIndex = startIndex + i + 1;
            if (exclusiveEndIndex <= s.length()) {
                String substring = s.substring(startIndex, exclusiveEndIndex);
                if (substring.length() >= 2 && substring.startsWith("0")) {
                    continue;
                }

                int tmp = Integer.parseInt(substring);
                if (tmp < 1 || tmp > 26) {
                    continue;
                }
                dfs(exclusiveEndIndex, str + (char)(tmp + 64));
            }

        }
    }

    public int solution(String s){
        this.s = s;
        dfs(0, "");
        return answer.size();
    }

    public static void main(String[] args){
        System.out.println(new Q6().solution("25114"));
        System.out.println(new Q6().solution("23251232"));
        System.out.println(new Q6().solution("21020132"));
        System.out.println(new Q6().solution("21350"));
        System.out.println(new Q6().solution("120225"));
        System.out.println(new Q6().solution("232012521"));
    }
}
