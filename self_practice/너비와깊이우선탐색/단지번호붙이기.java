package self_practice.너비와깊이우선탐색;
import java.io.*;
import java.util.*;
public class 단지번호붙이기 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int dRow[] = {0, 0, -1, 1};
        int dCol[] = {-1, 1, 0, 0};

        //첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
        int N = Integer.parseInt(br.readLine());

        int[][]map = new int[N][N];
        ArrayList<Integer> solution = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = row.charAt(j) - '0';
            }
        }
//
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }

        int area = 0;

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {

                if (map[i][j] == 1) {
                    Deque<int[]> q = new ArrayDeque<>();
                    q.addFirst(new int[]{i, j});
                    area++;

                    int sizeOfArea = 0;
                    while (!q.isEmpty()) {
                        int[] node = q.removeLast();

                        if (map[node[0]][node[1]] == 1) {
                            map[node[0]][node[1]] = -1;
                            sizeOfArea++;

                            for (int k = 0; k < 4; k++) {
                                int cRow = node[0] + dRow[k];
                                int cCol = node[1] + dCol[k];

                                if (cRow >= 0 && cRow <= N - 1 && cCol >= 0 && cCol <= N - 1) {
                                    q.addFirst(new int[]{cRow, cCol});
                                }
                            }
                        }
                    }
                    solution.add(sizeOfArea);
                }
            }
        }
        Collections.sort(solution);

        bw.write(area + "\n");
        for(int sizeOfArea : solution){
            bw.write(sizeOfArea + "\n");
        }
        bw.flush();
    }
}
