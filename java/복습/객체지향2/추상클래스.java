package 복습.객체지향2;

public class 추상클래스 {
    public static void main(String[] args) {
        Unit[] grop = {new Marin(),new Dropship(),new Tank()};

        for (int i = 0; i <grop.length ; i++) {
            grop[i].move(100,200);
        }
    }
}
abstract class Unit{
    int x,y;
    abstract void move(int x, int y);//추상클래스
    void stop(){}  //현재위치에 정지
}
class Marin extends Unit{
    @Override
    void move(int x, int y) {//추상클래스를 이용해 오버라이딩
        System.out.printf("Marin[x=%d,y=%d]\n",x,y);
    }
    void stimpack(){}
}

class Tank extends Unit{
    @Override
    void move(int x, int y) {
        System.out.printf("Tank[x=%d,y=%d]\n",x,y);
    }
    void changeMode(){}
}
class Dropship extends Unit{
    @Override
    void move(int x, int y) {
        System.out.printf("Dropship[x=%d,y=%d]\n",x,y);
    }
    void load(){}
    void unload(){}
}