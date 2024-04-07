package april_week1;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class 회의실_배정 {
    public static void main(String[]args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] sortedArray = new int[T][2];

        StringTokenizer st;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            sortedArray[i][0] = num1;
            sortedArray[i][1] = num2;
        }

//        Arrays.sort(sortedArray, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1, int[] o2){
//                if(o1[1] != o2[1])
//                    return o1[1] - o2[1];
//                else
//                    return o1[0] - o2[1];
//            }
//        });

        Arrays.sort(sortedArray, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        //sortedArray = Stream.of(sortedArray).sorted((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]).toArray(int[][]::new);

        for(int[] t : sortedArray) {
            System.out.println(Arrays.toString(t));
        }

        int cnt = 1;

        int lastEndTime = sortedArray[0][1];
        int currentStartTime, currentEndTime;

        for(int i = 1; i < T; i++){
            currentStartTime = sortedArray[i][0];
            currentEndTime = sortedArray[i][1];

            if(currentStartTime >= lastEndTime){
                cnt++;
                lastEndTime = currentEndTime;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
    }
}
