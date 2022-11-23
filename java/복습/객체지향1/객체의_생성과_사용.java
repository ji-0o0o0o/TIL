package 복습.객체지향1;

public class 객체의_생성과_사용 {
    public static void main(String[] args) {
        Tv t;         //Tv인스턴스를 참조하기 위한 변수 참조변수t선언
        t = new Tv(); //Tv인스턴스를 생성
        t.channel = 7; //변수사용
        t.channelDown(); // 메서드 사용(호출)
        System.out.println(t.channel);

    }
}
class Tv{
    //Tv의 속성(멤버변수)
    String color;
    boolean power;
    int channel;

    //Tv의 기능(메서드)
    void power(){power = !power;}
    void channelUp() {++channel;}
    void channelDown() {--channel;}

}
