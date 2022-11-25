package 복습.객체지향2;

//super : 객체 자신을 가르키는 참조변수, 인스턴스 메서드(생성자) 내에서만 존재 (static 불가)
// 조상멤버 super, 자신멤버 this 구별에 사용
public class 참조변수super {
    public static void main(String[] args) {
        Child child = new Child();//같은 이름의 멤버변수 구별하는데 super와 this가 쓰임
        child.method();

        System.out.println();
        Child2 child2 = new Child2(); //같은 x의 값을 가르키니까 같은 값이 출력
        child2.method();
    }
}
class Parent{int x =10;}//super.x

class Child extends Parent{
    int x = 20; //this.x

    void method(){
        System.out.println("x :"+x);
        System.out.println("super.x :"+super.x);
        System.out.println("this.x :"+this.x);
    }
}
class Parent2{int x =10;}//super.x와 this.x 둘다 가능
class Child2 extends Parent2{
    void method(){
        System.out.println("x :"+x);
        System.out.println("super.x :"+super.x);
        System.out.println("this.x :"+this.x);
    }
}


