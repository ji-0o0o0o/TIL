package 복습.객체지향2;

public class 내부클래스_제어자_접근성1 {
    class InstanceInner {
        int iv = 100;
//        static int cv = 100; // 에러발생, static 변수 선언x
        final static int CONST =100;//final static은 상수이므로 가능
    }

    static class StaticInner{
        int iv =200;
        static int cv = 100;//static 클래스이므로 static멤버를 정의 가능
    }

    void myMethod(){
        class  LocalInner{
            int iv = 300;
//            static int cv = 300;
            final static int CONST =100;
        }
    }

    public static void main(String[] args) {//상수와 static클래스만 불러올 수 있음
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
//        System.out.println(LocalInner.CONST);//에러, 지역내부 클래스는 메서드 내에서만
    }
}
