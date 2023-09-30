package advanced.ch2;

import java.util.*;

public class Q7 {

    private int parseTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    public String[] solution(String[] reports, int time){

        // lastInTime, totalTime;
        Map<String, Integer[]> map = new HashMap<>();
        for (String report : reports) {
            String[] splits = report.split(" ");

            String name = splits[0];
            int parsedTime = parseTime(splits[1]);
            String state = splits[2];

            map.putIfAbsent(name, new Integer[]{null, 0});
            if (Objects.equals(state, "in")) {
                map.get(name)[0] = parsedTime;
            } else {
                // out
                map.get(name)[1] += parsedTime - map.get(name)[0];
                map.get(name)[0] = null;
            }
        }

        List<String> names = new ArrayList<>();
        for(Map.Entry<String, Integer[]> entry : map.entrySet()) {
            Integer[] value = entry.getValue();
            if (value[1] > time) {
                names.add(entry.getKey());
            }
        }

        return names.toArray(String[]::new);
    }

    public static void main(String[] args){
        Q7 T = new Q7();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
