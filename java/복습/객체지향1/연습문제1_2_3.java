package 복습.객체지향1;

public class 연습문제1_2_3 {
    public static void main(String[] args) {
        Student s = new Student("홍길동",1,1,100,60,76);

        String str = s.info();
        System.out.println(str);

        System.out.println("이름 : " +s.name);
        System.out.println("총점 : " +s.getTotal());
        System.out.println("평균 : " +s.getAverage());


    }
}
class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student() {
    }

    public Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String info() {

        return name+","+ban+","+no+","+kor+","+eng+","+math+","+(kor+eng+math)+","+(float)((int)(((kor+eng+math)/3.0)*10+0.5))/10;
        //0.5를 더해준 이유는 반올림 했을때를 생각해서
    }

    int getTotal() {
        return kor+eng+math;
    }
    float getAverage(){
        return (float) ((int)((getTotal()/3.0)*10+0.5))/10;
    }
}