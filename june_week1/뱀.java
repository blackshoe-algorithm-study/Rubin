package june_week1;

import java.io.*;
import java.util.*;

public class 뱀 {
    static int N;
    static int K;
    static int L;
    static int snakeLength = 1;
    static int[][] map;

    static int Time = 1;
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1]; //1,1부터 시작

        K = Integer.parseInt(br.readLine());
        List<Apple> apples = new ArrayList<Apple>(K);

        StringTokenizer st;

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            Apple apple = new Apple(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            apples.add(apple);
        }

        L = Integer.parseInt(br.readLine());
        List<DirectionInfo> directionInfos = new ArrayList<DirectionInfo>(L);

        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            DirectionInfo directionInfo = new DirectionInfo(Integer.parseInt(st.nextToken()), st.nextToken());
            directionInfos.add(directionInfo);
        }

        //뱀 생성
        Snake snake = new Snake();

        while(!isGameOver(snake.getHeadLocation(), snake.locations)){
            snake.move(map, apples, directionInfos);
        }


    }

    static class Snake{
        //L, D, F
        String status;
        List<Location> locations;


        public Snake(){
            //초기화
            this.status = "F";
            Location location = new Location(1,1);
            locations = new LinkedList<>();
            locations.add(location);
        }

        public void setStatus(String status){
            //L, D, F
            this.status = status;
        }

        public void addLocation(Location location){
            locations.add(location);
        }

        public Location getHeadLocation(){
            return locations.get(0);
        }
//        public void updateLocation(Location[] location){
//
//        }

        public void move(int[][] map, List<Apple> apples, List<DirectionInfo> directionInfos){

            status = "F";

            if(Time == directionInfos.get(0).time) {
                status = directionInfos.get(0).directionInfo;
            }

            List<Location> locationsBeforeMove = locations;
            List<Location> newLocations = new LinkedList<>();

            if(status == "F"){
                newLocations.add(new Location(this.getHeadLocation().x, this.getHeadLocation().y+1));
            }
            else if(status == "L"){

            }
            else if(status == "D"){

            }

            for(Location location : locationsBeforeMove){

            }

            for(int i = 0; i < K; i++){
                if(apples.get(0).x == this.getHeadLocation().x && apples.get(0).y == this.getHeadLocation().y){
                    snakeLength++;
                    Location newTail = this.locations.get(snakeLength-1);
                    locations.add(newTail);
                    break;
                }
            }
            Time++;
        }
    }
    static class Location{
        int x;
        int y;
        public Location(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setLocation(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Apple{
        int x;
        int y;
        public Apple(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class DirectionInfo{
        int time;
        String directionInfo;
        public DirectionInfo(int time, String directionInfo){
            this.time = time;
            this.directionInfo = directionInfo;
        }
    }

    static boolean isGameOver(Location head, List<Location> locations){
        //1. 머리가 벽에 닿거나
        if (head.x <= 0 || head.y <= 0 || head.x > N || head.y > N)
            return true;
        //2. 머리가 몸통에 닿거나
        for(int i = 1; i < snakeLength; i++){
            if(head.x == locations.get(i).x && head.y == locations.get(i).y) {
                return true;
            }
        }
        return false;
    }
}
