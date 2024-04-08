package april_week2;
import java.util.*;
import java.io.*;
/*
문제
하루에 한 시간 단위로 일을 하거나 일을 쉬어도 된다. 하루에 한 시간 일하면 피로도는 $A$만큼 쌓이고 일은 $B$만큼 처리할 수 있다.

만약에 한 시간을 쉰다면 피로도는 $C$만큼 줄어든다. 단, 피로도가 음수로 내려가면 $0$으로 바뀐다. 당연히 일을 하지 않고 쉬었기 때문에 처리한 일은 없다.

피로도를 최대한 $M$을 넘지 않게 일을 하려고 한다. $M$을 넘기면 일하는데 번아웃이 와서 이미 했던 일들도 다 던져버리고 일을 그만두게 된다.

번아웃이 되지 않도록 일을 할때 하루에 최대 얼마나 일을 할 수 있는지 구해보자. 하루는 24시간이다.

입력
첫 번째 줄에 네 정수 $A$, $B$, $C$, $M$이 공백으로 구분되어 주어진다.

맨 처음 피로도는 0이다.

일하는 시간 당 쌓이는 피로도 / 일하는 시간 당 처리하는 일 / 쉬는시간 당 줄어드는 피로도 / 번아웃 한계 피로도
출력
하루에 번 아웃이 되지 않도록 일을 할 때 최대 얼마나 많은 일을 할 수 있는지 출력한다.
 */
public class 피로도 {
    static int leftHours = 24;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int wP = Integer.parseInt(st.nextToken()); //working 피로도
        int W = Integer.parseInt(st.nextToken()); //일하는 시간(최대로)
        int rP = Integer.parseInt(st.nextToken()); //rest 피로도
        int limit = Integer.parseInt(st.nextToken()); // 피로도 한계

        //피로도, 일하는 시간 쌓고, limit 한계 시 쉬고를 반복

        int cP = 0;
        int sumW = 0;
        boolean flag = true;

        while(leftHours >= 0 && flag){
            if(cP+wP <= limit) {
                cP += wP;
                sumW += W;
//                System.out.println("cP : " + cP + " wP : " + wP + " sumW : " + sumW + " limit : " + limit);
            }else{
                cP = cP-rP <= 0 ? 0 : cP-rP;
//                System.out.println("cP : " + cP + " rP : " + rP + " limit : " + limit);
            }
            leftHours--;
            if(leftHours == 0) flag = false;
        }

        bw.write(String.valueOf(sumW) + "\n");

        bw.flush();
    }

}
