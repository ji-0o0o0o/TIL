package 복습.객체지향1;

import java.util.Date;

class Data{int x ;}

public class 기본형_매개변수 {
    public static void main(String[] args) {
        Data d = new Data();
        d.x=10;
        System.out.printf("main() : x = %d\n",d.x);

        change(d.x);
        System.out.println("after change(d.x)");
        System.out.printf("main() : x = %d\n",d.x);
    }
    static void change(int x){ // 기본형 매개변수
        x = 1000;
        System.out.printf("x = %d\n",x);
        //기본형 매개변수로 변경이 d.x의 값이 변경된것이 아니라 매개변수 x 값이 변경된것
    }
}
