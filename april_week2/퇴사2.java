package april_week2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 퇴사2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Node> consultations = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            consultations.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        퇴사2 solver = new 퇴사2();
        bw.write(solver.maxProfit(0, consultations, N) + "\n");
        bw.flush();
    }

    public int maxProfit(int day, List<Node> consultations, int N) {
        // 기저 조건: 모든 상담을 고려한 경우
        if (day >= N) {
            return 0;
        }

        // 상담을 진행하지 않는 경우 (분기)
        int profitWithout = maxProfit(day + 1, consultations, N);

        // 상담을 진행하는 경우 (분기)
        int profitWith = 0;
        if (day + consultations.get(day).days <= N) { // 상담이 가능한 경우
            profitWith = consultations.get(day).distance + maxProfit(day + consultations.get(day).days, consultations, N);
        }

        // 두 경우 중 최대 이익 반환
        return Math.max(profitWithout, profitWith);
    }

    static class Node {
        int days;
        int distance;

        Node(int days, int distance) {
            this.days = days;
            this.distance = distance;
        }
    }
}

