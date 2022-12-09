package 복습.객체지향2;

public class 디폴트메서드와_static메서드 {
    public static void main(String[] args) {
        Child3 c = new Child3();
        c.method1(); //child3
        c.method2(); //Parent3
        MyInterface.staticMethod();//static메서드에서는 static 메서드 가져올 수 있음
        MyInterface2.staticMethod();
    }
}

class Parent3{
    public void method2(){
        System.out.println("method2() in Parent3");
    }
}
interface MyInterface{

    default void method1(){//defalt메서드
        System.out.println("method1() in MyInterface");
    }
    default void method2(){//defalt메서드
        System.out.println("method2() in MyInterface");
    }
    static void staticMethod(){
        System.out.println("staticMethod() in MyInterface");
    }
}
interface MyInterface2{
    default void method1(){//defalt메서드
        System.out.println("method1() in MyInterface2");
    }
    static void staticMethod(){
        System.out.println("staticMethod() in MyInterface2");
    }
}
class Child3 extends Parent3 implements MyInterface,MyInterface2{
    public void method1(){//오버라이딩
        System.out.println("method1() in Child3");
    }
}