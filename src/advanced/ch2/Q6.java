package advanced.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q6 {

    static class Report {
        String name;
        int parsedTime;

        public Report(String name, int parsedTime) {
            this.name = name;
            this.parsedTime = parsedTime;
        }
    }

    private int parseTime(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour * 60 + minute;
    }

    public String[] solution(String[] reports, String times){

        int start = parseTime(times.split(" ")[0]);
        int end = parseTime(times.split(" ")[1]);

        List<Report> reportList = new ArrayList<>();
        for (String report : reports) {
            String name = report.split(" ")[0];
            int parsedTime = parseTime(report.split(" ")[1]);
            if (parsedTime >= start && parsedTime <= end) {
                reportList.add(new Report(name, parsedTime));
            }
        }

        reportList.sort(Comparator.comparingInt(o -> o.parsedTime));
        String[] answer = new String[reportList.size()];
        for (int i = 0; i < reportList.size(); i++) {
            answer[i] = reportList.get(i).name;
        }
        return answer;
    }

    public static void main(String[] args){
        Q6 T = new Q6();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }
}
