package 복습.객체지향1;

public class 연습문제4_6 {
//    static double getDistance(int x, int y, int x1, int y1){
//        return Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2));
//    }

    public static void main(String[] args) {
        Point p = new Point(1,1);
        System.out.println(p.getDistance(2,2));
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    double getDistance(int x1, int y1){
        return Math.sqrt(Math.pow(x-x1,2)+Math.pow(y-y1,2));
    }
}