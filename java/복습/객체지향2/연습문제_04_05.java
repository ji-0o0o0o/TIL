package 복습.객체지향2;

class MyTv{
    boolean isPowerOn;
    int channel;
    int volume;
    int pre = 0;

    final int MAX_VOLUME =100;
    final int MIN_VOLUME =1;
    final int MAX_CHANNEL =100;
    final int MIN_CHANNEL =0;

    public void setVolume(int volume){
        if (volume<MIN_VOLUME||volume>MAX_VOLUME){
            return;
        }
        this.volume = volume;
    }

    public int getVolume(){
        return volume;
    }

    public void setChannel(int channel){
        if (volume<MIN_CHANNEL||volume>MAX_CHANNEL){
            return;
        }
        pre = this.channel;
        this.channel = channel;
    }

    public int getChannel(){

        return channel;
    }

    void gotPrevChannel(){
        setChannel(pre);
    }
}
public class 연습문제_04_05 {
    public static void main(String[] args) {
        MyTv t = new MyTv();

        t.setVolume(20);
        System.out.println("VOL: "+t.volume);

        t.setChannel(10);
        System.out.println("channel: "+t.channel);
        t.setChannel(13);
        System.out.println("channel: "+t.channel);

        t.gotPrevChannel();
        System.out.println("channel: "+t.channel);
    }
}
