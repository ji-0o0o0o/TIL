package 복습.객체지향1;

class MyTv{
    boolean isPowerOn;
    int channel;
    int volume;

    final  int MAX_VOLUME = 100;
    final  int MIN_VOLUME =0;
    final  int MAX_CHANNEL =100;
    final  int MIN_CHANNEL =1;

    void turnOnOff(){ //isPowerOn값이 true면 flase로
        isPowerOn=!isPowerOn;
    }

    void volumeUp(){//MAX_VOLUME보다 낮으면 1증가

        if (volume<MAX_VOLUME){
            volume++;
        }
    }

    void volumeDown(){//MIN_VOLUME보다 크면 1감소
        if (volume>MIN_VOLUME){
            volume--;
        }
    }
    void ChannelUp(){//channel 1증가 MAX_CHANNEL이면 MIN_CHANNEL으로 변경

        if (channel==MAX_CHANNEL){
            channel=MIN_CHANNEL;
        }else {
            channel++;
        }
    }
    void ChannelDown(){//channel 1감소 MIN_CHANNEL이면 MAX_CHANNEL으로 변경
        if (channel==MIN_CHANNEL){
            channel=MAX_CHANNEL;
        }else {
            channel--;
        }
    }

}


public class 연습문제19 {
    public static void main(String[] args) {


        MyTv t = new MyTv();
        t.channel = 100;
        t.volume =0;
        System.out.printf("CH: %d, VOL: %d \n",t.channel,t.volume);

        t.ChannelDown();
        t.volumeDown();
        System.out.printf("CH: %d, VOL: %d \n",t.channel,t.volume);

        t.volume=100;
        t.ChannelUp();
        t.volumeUp();
        System.out.printf("CH: %d, VOL: %d \n",t.channel,t.volume);

        t.ChannelUp();
        t.volumeDown();
        System.out.printf("CH: %d, VOL: %d \n",t.channel,t.volume);

        System.out.println(t.isPowerOn);
        t.turnOnOff();
        System.out.println(t.isPowerOn);

    }
}
