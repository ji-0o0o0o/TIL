package 복습.객체지향1;

class Data3{int x ;}

public class 참조형_반환타입 {
    public static void main(String[] args) {
        Data3 d = new Data3();
        d.x=10;
        System.out.printf("main() : x = %d\n",d.x);

        Data3 d2 = copy(d);
        System.out.printf("d.x = %d\n",d.x);
        System.out.printf("d2.x = %d\n",d2.x);
    }
    static Data3 copy(Data3 d){ //반환타입 참조형
        Data3 tmp = new Data3();//새로운 객체 tmp생성
        tmp.x = d.x;//d.x를 tmp에 복사
        return tmp; //복사한 객체의 주소 반환

    }
}
