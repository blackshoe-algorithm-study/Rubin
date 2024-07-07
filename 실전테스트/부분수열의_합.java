package 실전테스트;

import java.io.*;
import java.util.*;

public class 부분수열의_합 {
    static ArrayList<Integer> sums = new ArrayList<>();
    static int[] numbers;
    static int N;

    public static void main(String[]args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        generateSums(0, 0);
        Collections.sort(sums);

        int result = 1;
        for (int sum : sums){
            //1부터 시작하므로 sum보다 작은 자연수의 경우: 출력
            if (sum == result){
                result++;
            }else if(sum > result){
                break;
            }
        }

        bw.write(result+"\n");
        bw.flush();
    }
    static void generateSums(int index, int currentSum){
        if(index == N){
            sums.add(currentSum);
            return;
        }

        generateSums(index + 1, currentSum + numbers[index]);
        generateSums(index + 1, currentSum);
    }
}
