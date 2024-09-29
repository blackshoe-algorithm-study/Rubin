package toss_NEXT;

import java.io.*;
import java.util.*;

public class 상어_초등학교 {
    static int N;
    static int[][] CLASS;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static Map<Integer, ArrayList<Integer>> preferMap;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        CLASS = new int[N][N];
        preferMap = new HashMap<>();
        List<Integer> studentOrder = new ArrayList<>();

        StringTokenizer st;

        for(int i = 0; i < N*N; i++){
            st = new StringTokenizer(br.readLine());

            int student = Integer.parseInt(st.nextToken());
            studentOrder.add(student);

            ArrayList<Integer> preferList = new ArrayList<>();
            for(int j = 0; j < 4; j++){
                preferList.add(Integer.parseInt(st.nextToken()));
            }
            preferMap.put(student, preferList);
        }

        for(int student : studentOrder){
            int[] seat = findBestSeat(student);
            CLASS[seat[0]][seat[1]] = student;
        }

        long result = calculateSatisfaction();

        bw.write(result + "\n");
        bw.flush();
    }

    static int[] findBestSeat(int student){
        int[] bestSeat = new int[2];
        int maxPreferCnt = -1;
        int maxEmptyCnt = -1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(CLASS[i][j] != 0) continue;

                int preferCnt = 0;
                int emptyCnt = 0;

                for(int k = 0; k < 4; k++){
                    int cRow = i + dRow[k];
                    int cCol = j + dCol[k];

                    if(cRow >= 0 && cCol >= 0 && cRow < N && cCol < N){
                        if(preferMap.get(student).contains(CLASS[cRow][cCol]))
                            preferCnt++;
                        if(CLASS[cRow][cCol] == 0) emptyCnt++;
                    }
                }

                if(preferCnt > maxPreferCnt ||
                        (preferCnt == maxPreferCnt && emptyCnt > maxEmptyCnt) ||
                        (preferCnt == maxPreferCnt && emptyCnt == maxEmptyCnt &&
                                (i < bestSeat[0] || (i == bestSeat[0] && j < bestSeat[1])))){
                    maxPreferCnt = preferCnt;
                    maxEmptyCnt = emptyCnt;
                    bestSeat[0] = i;
                    bestSeat[1] = j;
                }
            }
        }
        return bestSeat;
    }

    static long calculateSatisfaction(){
        long result = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int cnt = 0;

                for(int k = 0; k < 4; k++){
                    int cRow = i + dRow[k];
                    int cCol = j + dCol[k];

                    if(cRow >= 0 && cCol >= 0 && cRow < N && cCol < N){
                        if(preferMap.get(CLASS[i][j]).contains(CLASS[cRow][cCol]))
                            cnt++;
                    }
                }

                result += cnt == 0 ? 0 : Math.pow(10, cnt - 1);
            }
        }
        return result;
    }
}

