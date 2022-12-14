package 복습.객체지향2;

class Outer{
    class Inner{
        int iv =100;
    }
}
class Outer2{
    static class Inner2{
        int iv =200;
    }
}
public class 연습문제_06 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        System.out.println(inner.iv);
        //외부클래스의 인스턴스를 먼저생성
        //인스턴스 클래스의 인스턴스 생성가능 -> 내부 클래스 객체 생성

        Outer2.Inner2 inner2 = new Outer2.Inner2();
        System.out.println(inner2.iv);
        //static 내부 클래스의 인스턴스는 외부 클래스를 먼저 생성하지 않아도 된다.
    }
}
