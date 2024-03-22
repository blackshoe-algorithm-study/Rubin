package march_week3;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class ATM {
    public static void main(String[]args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int times = Integer.parseInt(br.readLine());

        List<Integer> list = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        int[] sum = new int[times];

        IntStream.range(0, times)
                .forEach(i -> sum[i] = (i == 0 ? 0 : sum[i-1]) + list.get(i));

        int solution = Arrays.stream(sum).sum();

        bw.write(String.valueOf(solution));
        bw.flush();
    }
}
