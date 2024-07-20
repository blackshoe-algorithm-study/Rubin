package self_practice;
import java.io.*;
import java.util.*;
public class 가장_긴_증가하는_부분수열 {
    static int N;
    public static void main(String[]args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                //점화식 작성, dp배열에 저장, 무엇을? 점화식 결과를. dp[j] =
                if(nums[i] > nums[j]){
                    //1 -> 0, 2 -> 0, 1, 3 -> 0, 1, 2,
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    /*
                    현재 인덱스보다 낮은 인덱스의 모든 숫자를 수열 내에서 탐색함.
                     만약 현재 인덱스의 숫자가 낮은 인덱스의 숫자보다 큰 경우,
                    dp[현재 인덱스], dp[낮은 인덱스 중 하나] + 1 이 둘을 비교해서 더 큰 것을 dp[현재 인덱스]에 넣어줌.
                    왜 dp[현재 인덱스]는 비교되어야 하냐는 질문엔
                    낮은 인덱스는 여러개 존재할 수 있고 기존에 같은 반복문 depth에서 nums[i] > nums[j]를 통과한 다른 수가 있을 수 있음.
                    해당 경우 역시 dp를 갖고 있기에 이런식으로 진행함.
                     */
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
