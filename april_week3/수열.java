//package april_week3;
//
//import java.io.*;
//import java.util.*;
//
//public class 수열 {
//    public static void main(String[]args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int size = Integer.parseInt(st.nextToken());
//        int window = Integer.parseInt(st.nextToken());
//
//        List<Integer> arraylist = new ArrayList<>(size);
//
//        st = new StringTokenizer(br.readLine());
//
//        for(int i = 0; i < size; i++){
//            arraylist.add(Integer.parseInt(st.nextToken()));
//        }
//        int max = Integer.MIN_VALUE;
//        int left = 0; int right = 0;
//        int sum = 0;
//        while(right < size){
//
////            if(left + right)
////
////            sum += arraylist.get(left)
//
//
//        }
//
//
//
//
//        //j = i+1; j < window;
//        //j가 size에 도달 시 break;
//        boolean flag = false;
//
//
//        for(int i = 0; i < size; i++){
//            if(flag) break;
//            int sum = 0;
//
//            for(int j = i; j < i+window; j++){
//                if(j == size-1) {
//                    flag = true;
//                    break;
//                }
//                sum += arraylist.get(j);
//            }
//
//            max = Math.max(sum, max);
//        }
//
//        bw.write(max + "\n");
//        bw.flush();
//        bw.close();
//
//        br.close();
//    }
//}
