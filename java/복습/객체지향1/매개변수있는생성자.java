package 복습.객체지향1;

class Car{
    String color; //car의 멤버변수(속성)
    String gearType;
    int door;

    Car(){};//기본생성자

    Car(String color, String gearType, int door) {//매개변수 있는 생성자
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
public class 매개변수있는생성자 {
    public static void main(String[] args) {
        Car c1 = new Car(); //객체 생성
        c1.color = "white"; //car의 멤버변수들 값지정해준다.
        c1.door = 4;
        c1.gearType="auto";

        Car c2 = new Car("white","auto",4);
        //-> 코드 간결 직관적으로 사용가능, 별도로 초기화 해주지 않아도 됨
        System.out.println("c1= " +c1.color+c1.gearType+c1.door);
        System.out.println("c2= " +c2.color+c2.gearType+c2.door);
    }
}
