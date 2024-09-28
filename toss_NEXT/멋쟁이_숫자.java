package toss_NEXT;
import java.io.*;
import java.util.*;
/*
길이가 '3'인

예시 1
입력: s = “12223”
출력: 222
예시 2
입력: s = “111999333”
출력: 999
설명: 111, 333, 999 3가지가 존재하고 999가 제일 크므로 999를 리턴합니다.
예시 3
입력: s = “123”
출력: -1
 */
public class 멋쟁이_숫자 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int max = -1;

//        int left = 0;
//        int right = 1;
//        while(left < right){
//            int turn = 2;
//
//            while(turn-->0) {
//                boolean flag = true;
//
//                if (s.charAt(left) == s.charAt(right)) {
//                    right = right >= s.length()-1 ? right : right+1;
//                    if(right == s.length()-1) left++;
//                }
//                else if (s.charAt(left) != s.charAt(right)) {
//                    if(turn == 1) {
//                        left++;
//                        right = right >= s.length()-1 ? right : right+1;
//                    }
//                    else if(turn == 0) { left++;}
//                    flag = false;
//                }
//                if(flag && turn==0) max = Math.max(max, (s.charAt(right) - '0') * 111);
//            }
//        }

        //Claude가 준 코드. 좋다.
        for(int i = 0; i <= s.length() - 3; i++){
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == s.charAt(i+2)){
                int currentNum = Integer.parseInt(s.substring(i, i+3));
                max = Math.max(max, currentNum);
            }
        }
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
