package 복습.객체지향1;

class Data2{int x ;}

public class 참조형_매개변수 {
    public static void main(String[] args) {
        Data2 d = new Data2();
        d.x=10;
        System.out.printf("main() : x = %d\n",d.x);

        change(d);
        System.out.println("after change(d.x)");
        System.out.printf("main() : x = %d\n",d.x);
    }
    static void change(Data2 d){ // 참조형 매개변수
        //매개변수를 참조형으로 선언했기때문에 x값이 아닌 변수 d의 주소가 매개변수 d에 복사되었다.
        //main 참조변수 d 와 change의 참조변수d는 같은 객체를 가르키게 된다.
        d.x = 1000;
        System.out.printf("x = %d\n",d.x);
        //참조형 매개변수는 값이 저장된 주소를 change메서드에 넘겨주었기때문에 읽기+변경 가능
    }
}
