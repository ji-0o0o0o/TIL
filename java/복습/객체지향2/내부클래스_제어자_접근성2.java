package 복습.객체지향2;

public class 내부클래스_제어자_접근성2 {
    //인스턴스멤버와 static멤버는 같은 멤버끼리는 접근가능
    //인스턴스멤버는 static멤버에 접근가능
    //but, static멤버는 인스턴스 멤버에 접근 불가!!
    class InstanceInner{}
    static class StaticInner{}

    InstanceInner iv = new InstanceInner();
    StaticInner cv = new StaticInner();

    static void staticMethod(){
        //static 멤버는 인스턴스 멤버 접근 불가
//        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        //static메서드에서 인스턴스클래스 불러오고 싶으면 객체를 먼저 생성해야함
        //인스턴스 클래스는 외부 클래스 먼저 불러와야함
        내부클래스_제어자_접근성2 outer = new 내부클래스_제어자_접근성2();
        InstanceInner obj1 = outer.new InstanceInner();
        //근데 이렇게 쓸필요는 없음
    }
    void instatnceMethod(){
        //인스턴스메서드는 인스턴스클래스, static클래스둘다 접근 가능
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();

        //메서드 내에 지역적으로 선언된 내부 클래스는 외부에서 접근 불가
//        LocalInner lv = new LocalInner();
    }

    void myMethod(){
         class LocalInner{}
        LocalInner lv = new LocalInner();
    }
}
