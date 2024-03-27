package march_week4;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class 전화번호_목록{
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            Map<char[], Integer> hashMap = new HashMap<>();

            int t = Integer.parseInt(br.readLine());

            for(int i = 0; i < t; i++){
                minHeap.add(Integer.parseInt(br.readLine()));
            }

            String flag = "YES";

            for(int k = 0; k < t-1; k++) {

                char[] currentNum = String.valueOf(minHeap.remove()).toCharArray();
                int currentSizeOfNum = currentNum.length;
                hashMap.put(currentNum, k);

                for(int I = k+1; I < t; I++){
                    int nextNum = minHeap.remove();

                    char[] nextNumm = String.valueOf(nextNum).toCharArray();
                    char[] rangeNextNum = new char[currentSizeOfNum];

                    for(int J = 0; J < currentSizeOfNum; J++){
                        rangeNextNum[J] = nextNumm[J];
                    }

                    if(hashMap.get(rangeNextNum) != null) {
                        flag = "NO";
                        break;
                    }else{

                        minHeap.add(nextNum);
                    }
                }

                if(flag == "NO")
                    break;
            }
            bw.write(flag+"\n");
        }
        bw.flush();
    }
}
