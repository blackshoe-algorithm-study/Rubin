package 실전테스트4;

import java.io.*;
import java.util.*;

public class 세_용액 {
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int N;
    static Long[] originArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        originArr = new Long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            originArr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(originArr);
        combination(new ArrayList<>(), 0, 0L);

        Node result = pq.peek();
        Collections.sort(result.comb);

        for (int i = 0; i < 3; i++) {
            bw.write(result.comb.get(i) + "");
            if (i != 2) bw.write(" ");
        }
        bw.flush();
    }

    static void combination(ArrayList<Long> list, int idx, Long currSum) {
        if (list.size() == 3) {
            pq.offer(new Node(currSum, new ArrayList<>(list)));
            if (pq.size() > 1) {
                pq.poll(); // 절댓값이 더 큰 것을 제거
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            list.add(originArr[i]);
            combination(list, i + 1, currSum + originArr[i]);
            list.remove(list.size() - 1);
        }
    }
}

class Node implements Comparable<Node> {
    Long sum;
    ArrayList<Long> comb;

    public Node(Long sum, ArrayList<Long> comb) {
        this.sum = sum;
        this.comb = comb;
    }

    @Override
    public int compareTo(Node other) {
        return Long.compare(Math.abs(other.sum), Math.abs(this.sum));
    }
}