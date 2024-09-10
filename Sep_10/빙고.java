package Sep_10;
import java.io.*;
import java.util.*;
public class 빙고 {
    static int BINGO = 0;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Node> map = new HashMap<>();

        boolean[][] testMap = new boolean[5][5];

        StringTokenizer st;

        for(int i = 0; i < 5; i++){
             st = new StringTokenizer(br.readLine());
             for(int j = 0; j < 5; j++){
                Node node = new Node(i, j);
                map.put(Integer.parseInt(st.nextToken()), node);
             }
        }

        int sol = 0;
        for(int i = 0; i < 5; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                sol++;
                int calledIdx = Integer.parseInt(st.nextToken());
                Node calledNode = map.get(calledIdx);
                testMap[calledNode.row][calledNode.col] = true;

                isBingo(testMap);

                if(BINGO >= 3){
                    bw.write(sol + "\n");
                    bw.flush();
                    return;
                }
            }
        }
    }

    public static void isBingo(boolean[][] tMap){
        BINGO = 0;
        //가로
        for(int i = 0; i < 5; i++){
            int len = 0;
            for(int j = 0; j < 5; j++){
                if(tMap[i][j] == false) break;
                else len++;
            }
            if(len == 5) {BINGO++;
            }
        }

        //세로
        for(int i = 0; i < 5; i++){
            int len = 0;
            for(int j = 0; j < 5; j++){
                if(tMap[j][i] == false) break;
                else len++;
            }
            if(len == 5) {
                BINGO++;
            }
        }
        int len = 0;
        //대각선
        for(int i = 0; i < 5; i++){
            if(tMap[i][i] == false) break;
            else len++;
        }

        if(len == 5) {
            BINGO++;

        }
        len = 0;
        for(int i = 0; i < 5; i++){
            if(tMap[i][4-i] == false) break; // 0,4 1,3 2,2 3,1 4,0
            else len++;
        }

        if(len == 5) {
            BINGO++;
        }
    }
}

class Node{
    int row;
    int col;
    public Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}

/*
첫째 줄부터 다섯째 줄까지 빙고판에 쓰여진 수가 주어진다.
여섯째 줄부터 열번째 줄까지 사회자가 부르는 수가 차례대로 한 줄에 다섯 개씩 주어진다.
 */
