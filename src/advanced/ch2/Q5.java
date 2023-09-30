package advanced.ch2;

import java.util.*;

public class Q5 {

    public String solution(String[] votes, int k){

        Map<String, List<String>> voteMap = new HashMap<>();
        for (String vote : votes) {
            String[] names = vote.split(" ");
            voteMap.putIfAbsent(names[1], new ArrayList<>());
            voteMap.get(names[1]).add(names[0]);
        }

        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : voteMap.entrySet()) {
            if (entry.getValue().size() >= k) {

                for (String name : entry.getValue()) {
                    result.put(name, result.getOrDefault(name, 0) + 1);
                }
            }
        }

        Integer cur = 0;
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() >= cur) {
                if (!entry.getValue().equals(cur)) {
                    answer.clear();
                }
                answer.add(entry.getKey());
                cur = entry.getValue();
            }
        }

        answer.sort(String::compareTo);
        return answer.get(0);
    }

    public static void main(String[] args){
        Q5 T = new Q5();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
