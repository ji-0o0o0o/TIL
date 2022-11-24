package 복습.객체지향1;

//this()
//생성자 이름으로 클래스 이름 대산 this사용
//한 생성자에서 다른 생성자를 호출할때 맨 첫줄에 적어준다
class Car2{
    String color; //car의 멤버변수(속성)
    String gearType;
    int door;

    //1.
    Car2(String color, String gearType, int door) {//매개변수 있는 생성자
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    //2.
    Car2(){
        this("whte","auto",4);
        //1.의 생성자를 호출-> 생성자끼리 호출하여 코드중복제거
    }
   //3.
    Car2(String color){
        this(color,"auto",4);
        //1.의 생성자를 호출
    }
}

public class 생성자에서_다른_생성자_호출 {
    public static void main(String[] args) {
        Car2 c1 = new Car2();           //2.호출
        Car2 c2 = new Car2("blue");//3.호출

        System.out.printf("c1의 색상 %s, 기어타입 %s, 문개수 %d\n",c1.color,c1.gearType,c1.door);
        System.out.printf("c2의 색상 %s, 기어타입 %s, 문개수 %d",c2.color,c2.gearType,c2.door);
    }
}
