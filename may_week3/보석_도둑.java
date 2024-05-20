package may_week3;

import java.io.*;
import java.util.*;
public class 보석_도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());
        Integer K = Integer.parseInt(st.nextToken());

        // 10짜리는 10보다 작은 보석들만 넣을 수 있고
        // 2짜리는 2보다 작은 보석들만 넣을 수 있고

        //key로 정렬
        PriorityQueue<Map<Integer, Integer>> mvQ = new PriorityQueue<>(N, new Comparator<Map<Integer, Integer>>(){
            @Override
            public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2){
                Integer key1 = o1.keySet().iterator().next();
                Integer key2 = o2.keySet().iterator().next();

                //return key1.compareTo(key2); 오름차순
                return key2.compareTo(key1); // 내림차순
            }
        });

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            Map<Integer, Integer> mv = new HashMap<>();

            mv.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            mvQ.add(mv); //Q에 추가, key 순 내림차순 정렬
        }

        /*
3 2
1 65
5 23
2 99
10
2

10
5 23
2 99
1 65

2
2 99
1 65
         */
        //보석들은 현재 pq에 무게 순으로 정렬되어있다.
        //제일 큰 가방에 들어갈 수 있는 보석들을 q에 넣는다. 다 넣으면 list에 q를 add한다.
        //그 다음 큰 가방에 들어갈 수 있는 보석들을 q에 넣는다. 다 넣으면 list에 q를 add한다.

        List<PriorityQueue<Integer>> pqList = new ArrayList<>(K);

        for(int i = 0; i < K; i++){



            PriorityQueue<Integer> maxQ = new PriorityQueue<>();

            int capa = Integer.parseInt(br.readLine());


            for(int j = 0; j < N; j++) {

            }

        }
    }
}
