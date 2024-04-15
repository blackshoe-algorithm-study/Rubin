//package april_week3;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class 수열2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int size = Integer.parseInt(st.nextToken());
//        int block = Integer.parseInt(st.nextToken());
//
//        //[size][block]
//        //block 수 만큼 2차원 배열에 저장
//
//        int[][] memo = new int[block][size];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<size; i++){
//            memo[0][i] = Integer.parseInt(st.nextToken());
//        }
//        int T = 1; //block-1번 반복
//
//        while(T++<block) {
//            memo[T][0] = memo[T-1][0] + memo[T-1][1];
//            memo[T][1] = memo[T-1][1] + memo[T-1][2];
//            ...
//            memo[T][size-1-1] = memo[T-1][size-1-1] + memo[T-1][size-1-1+1];
//            //
//
//            memo[T+1][0] = memo[T-1+1][0] + memo[T-1+1][1] + memo[T-1+1][2];
//            ...
//            memo[T+1][size-1-1-1] = 0;
//
//
//            for(int i = 0; i < block-1; i++){
//                memo[T][i] = memo[T-1]
//            }
//        }
//
//        /*
//            if(flag) break;
//            int sum = 0;
//
//            for(int j = i; j < i+block; j++){
//                if(j == size-1) {
//                    flag = true;
//                    break;
//                }
//                sum += arraylist.get(j);
//            }
//            max = Math.max(sum, max);
//         */
//    }
//}