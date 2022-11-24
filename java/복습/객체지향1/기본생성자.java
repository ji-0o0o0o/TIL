package 복습.객체지향1;

class data1{
    int value;

    data1(){};//기본생성자

}
class data2{
    int value;
//    data2(){};//기본생성자 적어주는 것이 좋음

    data2(int x ){
        value =x;
    }
}
public class 기본생성자 {
    public static void main(String[] args) {
        data1 d1 = new data1();
//        data2 d2 = new data2();//기본생성자 적어주지 않고 매개변수 있는 생성자 적어줘서 오류남
        data2 d2 = new data2(2);//이 경우 매개변수 생성자에 있는 매개변수를 이용하는 argument(인수)사용해야한다
    }
}
