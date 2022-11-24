package 복습.객체지향1;

public class 메서드간의_호출_참조 {
}
class TestClss{
    void instanceMethod(){} //인스턴스 메서드
    static void staticMethod(){}//static메서드

    void instanceMethod1() {//인스턴스 메서드
        instanceMethod();//다른 인스턴스 메서드 호출
        staticMethod();//static 메서드 호출
    }
    //같은 클래스에 속한 메서드 간에 별도의 인스턴스 생헝하지 않고 서로 참조 또는 호출 가능


    static void staticMethod2(){
//        instanceMethod();//static메서드에서 인스턴스 메서드 호출 안됨
        staticMethod();
    }
    //인스턴스 멤버 존재하는 시점에는 클래스 멤버 항상 존재, 그러나 클래스 멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수 있기때문

}
class TestClass2{
    int iv;
    static int cv;

    void instanceMethod(){
        System.out.println(iv);
        System.out.println(cv);
    }
    static void staticMethod(){
//        System.out.println(iv); //static메서드에서 인스턴스 변수도 호출 안됨
        System.out.println(cv);
    }
}