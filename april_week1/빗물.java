package april_week1;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class 빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < col; i++){
            int wall = Integer.parseInt(st.nextToken());
            for(int j = 0; j < wall; j++){
                map[j][i] = 1;
            }
        }
        //System.out.println(Arrays.deepToString(map));

        int cnt = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(map[i][j] == 0){
                    if(i == 0) {
                        cnt++;
                        map[i][j] = 1;
                    }
                    else{
                        continue;
                    }
                }

                if(j-1 >= 0) {

                }
                if(j+1 < col){

                }
            }
        }

    }
}
