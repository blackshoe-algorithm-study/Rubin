package april_week2;

import java.util.*;
import java.io.*;

public class 빙고 {
    static int[][] map = new int[5][5];
    static boolean[][] checked = new boolean[5][5]; // 숫자가 체크되었는지 직접 표시합니다.
    static int leftBingo = 0; // 빙고 카운트를 세는 방식을 변경합니다.

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> mc = new ArrayList<>(25);
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                mc.add(Integer.parseInt(st.nextToken()));
            }
        }

        int callCount = 0;
        for(int num : mc) {
            callCount++;
            markNumber(num);
            if(callCount >= 5 && checkBingo() >= 3) { // 최소 5번 호출 후에만 빙고 가능
                System.out.println(callCount);
                break;
            }
        }
    }

    static void markNumber(int num){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(map[i][j] == num) {
                    checked[i][j] = true;
                    return;
                }
            }
        }
    }

    static int checkBingo(){
        int count = 0;
        // 가로, 세로 빙고 확인
        for(int i = 0; i < 5; i++){
            boolean rowBingo = true, colBingo = true;
            for(int j = 0; j < 5; j++){
                if(!checked[i][j]) rowBingo = false;
                if(!checked[j][i]) colBingo = false;
            }
            if(rowBingo) count++;
            if(colBingo) count++;
        }

        // 대각선 빙고 확인
        boolean diag1 = true, diag2 = true;
        for(int i = 0; i < 5; i++){
            if(!checked[i][i]) diag1 = false;
            if(!checked[i][4-i]) diag2 = false;
        }
        if(diag1) count++;
        if(diag2) count++;

        return count;
    }
}
