package 복습.객체지향2;


    class Tv{
        boolean power; //멤버변수, 속성
        int channel;

        void power(){power =!power;};//인스턴스 메서드-> 기능담당
        void channelUp(){++channel;}
        void channelDown(){--channel;}
    }

    class SmartTv extends Tv {//smartTv는 Tv에 자막(캡션)을 보여주는 기능 추가
        //smsartTv가 Tv의 기능을 상속 받았으므로 smartTv는 Tv의 기능을 다 가지고 있다
        boolean caption;

        void displayCaption(String text) {
            if (caption) {//캡션상태가 true면 자막을 보여준다.
                System.out.println(text);
            }
        }
    }
public class 상속 {
    public static void main(String[] args) {
        SmartTv stv = new SmartTv();
        stv.channel=10;
        stv.channelUp();
        System.out.println(stv.channel);
        stv.displayCaption("Hello,World");
        stv.caption=true;
        stv.displayCaption("Hello,World");//caption을 켜줘서 자막 나온다
    }

}
