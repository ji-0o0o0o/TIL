package 복습.객체지향2;

public class super생성자 {//super()

    public static void main(String[] args) {
        Point3D p = new Point3D(1,2,3);
        System.out.printf("x : %d, y: %d, z : %d",p.x,p.y,p.z);
    }
}
class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Point3D extends Point{
    int z;
    Point3D(int x, int y,int z) {
        super(x, y);//생성자 첫줄에 반드시!! 안그러면 컴파일러가 자동으로 생성
        //조상의 멤버는 조상의 생성자로 초기화하는 것이 바람직
        this.z = z;
    }
}
