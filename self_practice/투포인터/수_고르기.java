package self_practice.투포인터;
import java.io.*;
import java.util.*;
public class 수_고르기 {
    static int[] nums;
    static int N, M, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        int left = 0;
        int right = N - 1;
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        int result = twoPointer();
        bw.write(result + "\n");
        bw.flush();
    }

    static int twoPointer() {
        int left = 0;
        int right = 0;
        int minDiff = Integer.MAX_VALUE;

        while (left < N && right < N) {
            int diff = nums[right] - nums[left];
            if (diff >= M) {
                minDiff = Math.min(minDiff, diff);
                left++;
            } else {
                right++;
            }
        }

        return minDiff;
    }
}
//    static void combination(int left, int right, int count){
//
//        if(right <= left) return;
//        System.out.println(nums[right] + " " + nums[left]);
//        int difference = nums[right] - nums[left];
//
//        if(difference >= M) min = Math.min(difference, min);
//
//        combination(left+1, right, count+1);
//        combination(left, right-1, count+1);
//        combination(left+1, right-1, count+1);
//    }

