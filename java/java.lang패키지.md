# java.lang패키지
<br/>

## Object 클래스

- 모든 클래스의 최고조상.
- 멤버변수는 없고 오직 11개의 메서드만 가지고 있음
- notify(),notifyAll(),wait()은 쓰레드와 관련

<br/>


### Object 클래스의 메서드 -equals()

- 객체 자신(this)과 주어진 객체(obj)를 비교한다.
- 반환값은 boolean
- Object 클래스의 equals()는 `객체의 주소를 비교`(참조변수 값 비교)
    
    <img width="345" alt="image" src="https://user-images.githubusercontent.com/102898794/199517494-143d757d-fb03-46a8-9547-cbbe2e81a915.png">
    
    - 객체자신하고 obj하고 같을 때 true
    
    ```java
    public static void main(String[] args) {
    		Value v1 = new Value(10);
    		Value v2 = new Value(10);
    
    		if (v1.equals(v2))
    			System.out.println("v1과 v2는 같습니다.");
    		else
    			System.out.println("v1과 v2는 다릅니다.");
    	} // main
    } 
    
    class Value {
    	int value;
    
    	Value(int value) {
    		this.value = value;
    			//오바라이딩을 해주지 않았다.
    	}
    ```
    
    <img width="429" alt="image" src="https://user-images.githubusercontent.com/102898794/199518011-2a52c623-bcd1-4b03-a9ca-4ca71c95596f.png">
    
    → 서로 다른 두 객체는 항상 주소가 다르다
    
    *10의 값을 가진 iv를 비교하려면 equls()를 오버라이딩해줘야한다.*
    
    ```java
    class Value {
    	int value;
    
    	Value(int value) {
    		this.value = value;
    	}
    
    	//Value의 조상인 Object의 equlas()를 오버라이딩해서 주소가 아닌 value를 비교
    	public boolean equals(Object obj){
    		//retrun this==obj; //주소비교, 서로다른 객체는 항상 거짓
    		//참조변수의 형변환 전에는 반드시 instanceof로 확인해야함
    		if(!(obj instanceof Value)) return false;
    
    		Value v = (Value)obj;//obj에는 value가 없어서 형변환 해줘야한다.
    		return this.value==v.value;
    	}  
    ```
    
    - 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩해야한다.
        - iv : 객체마다 다름(개별)
        - cv : 객체마다 공통(공유)
    
    <img width="676" alt="image" src="https://user-images.githubusercontent.com/102898794/199518212-189e6e6e-9dbf-4888-b792-6e4f897e4884.png">
    
<br/>

### Object 클래스의 메서드 - hashCode()

- 객체의 해쉬코드를 반환하는 메서드
- hashCode()는 객체의 주소를 int로 변환해서 반환
    - 객체의 주소로 만들기때문에 `객체마다 다른 값을 가짐`

```java
public class object{
	...
	public native int hashCode(); //내용 없음-> os메서드에서 메서드 가져오므로
```

** native(네이티브메서드) : os의 메서드(c언어)

- `equals()를 오버라이딩하면, hashCode()도 오버라이딩해야한다`
    - equlas,hashCode 모두 주소를 가지고 작업
    - but. equals()오버라이딩할때 iv로 작업하게 오버라이딩 하므로 hashCode()도 iv로 작업하게 같이 변경
- System.identityHashCode(Object obj)는 Object 클래스의 hashCode()와 동일함
    - System.identityHashCode(Object obj) : 객체마다 다른 해시코드 반환
    - 오버라이딩하기 이전 기능이 필요할때 쓰임
- 64bit JVM에서는 주소가 64bit 이므로 주소를 해시코드(32bit)로 변환하면 중복된 값이 나올 수 있다.
<br/>

### Object 클래스의 메서드 - toString()

- 객체를 문자열(String)으로 변환하기 위한 메서드
    - 객체==iv집합
    - 객체를 문자열로 변환한다는 것 iv의 값을 문자열로 변환한다는 것과 같음
- Object클래스에 정의된 toString()
    
    ```java
    public String toString(){
    	return getClass().getName()+"@"+Integer.toHexString(hashCode());
    	//.    설계도 객체   클래스이름. at/위치         16진수      객체주소
    ```
    
    → toString()을 호출하면 클래스이름과 16진수의 해시코드 얻음
    
- 일반적으로 인스턴스나 클래스에대한 정보 또는 인스턴스 변수들의 값을 문자열로 변환하여 반환하도록 오버라이딩되는 것이 보통
- 조상에 정의된 메서드를 자손에서 오버라이딩할때
    - 조상에 정의된 접근범위보다 같거나 넓어야 한다.
    
    ```java
    class Card2 {
    	String kind;
    	int number;
    
    	Card2() {
    		this("SPADE", 1);  // Card(String kind, int number)¸¦ È£Ãâ
    	}
    
    	Card2(String kind, int number) {
    		this.kind = kind;
    		this.number = number;
    	}
    	//Object클래스의 toStirng()을 오버라이딩
    	public String toString() { //card2의 iv를 문자열로 반환
    		return "kind : " + kind + ", number : " + number;
    	}
    }
    
    class Ex {
    	public static void main(String[] args) {
    		Card2 c1 = new Card2();
    		Card2 c2 = new Card2("HEART", 10);
    		System.out.println(c1.toString());
    		System.out.println(c2.toString());
    	}
    }
    ```
    
    - 만약 여기에 equals(), hashCode()쓰이면
        
        ```java
        class Card2 {
        	String kind;
        	int number;
        
        	Card2() {
        		this("SPADE", 1);  // Card(String kind, int number)¸¦ È£Ãâ
        	}
        
        	Card2(String kind, int number) {
        		this.kind = kind;
        		this.number = number;
         	}
        	//equals()를 오버라이딩 하면 hashCode()도 오버라이딩
        	public int hashCode(){
        		return Object.hash(kind, number); //-> 매개변수 가변인자라 지정값 정해져 있지x
        	}
        
        	public boolean equals(Object obj){ //오버라이딩이므로 선언부 같아야함
        		if(!(obj instanceof Card)) return false;
        
        		Card v = (Card)obj;.
        		return this.kind.equals(v.kind)&& this.number==v.number;
        	}
        
        	//Object클래스의 toStirng()을 오버라이딩
        	public String toString() { //card2의 iv를 문자열로 반환
        		return "kind : " + kind + ", number : " + number;
        	}
        }
        
        class Ex {
        	public static void main(String[] args) {
        		Card2 c1 = new Card2();
        		Card2 c2 = new Card2("HEART", 10);
        		System.out.println(c1.toString());
        		System.out.println(c2.toString());
        
        		System.out.println(c1.equals(c2)); //true
        		System.out.println(c1.hashCode()); //hashcode c1,c2 같은 값 출력
        		System.out.println(c2.hashCode());
        	}
        }
        ```
        
    
<br/>

## String 클래스

- `데이터(문자열) + 메서드(문자열 관련)`
- 내용을 변경할 수 없는 `불변(immutable) 클래스`
    - 한번 생성된 String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있고, 변경할 수는 없다.
        - “+”연산자를 이용해서 문자열 결합하는 경우
            
            문자열 바뀌는 것x, **새로운 문자열이 담긴 String 인스턴스 생성**
            
            ⇒ 덧셈 연산자(+)를 이용한 문자열 결합은 성능이 떨어짐
            
        - 문자열의 결합이나 변경이 잦다면, 내용을 변경가능한 StringBuffer를 사용
            
            
<br/>

### 문자열 비교

문자열 만드는 방법

- 문자열 리터럴을 지정하는 방법(str1, str2)
    - `String str = “abc”`
    - 내용변경 불가하기 때문에 공유 되어도 상관없음, 값 변경 안됨
- String클래스의 생성자를 사용해서 만드는 방법(str3,str4)
    - `String str = new String(”abc”)`
    - 항상 새로운 문자열 만들어짐
    → new연산자에 의해 메모리할당이 이뤄지기 때문에 새로운 String인스턴스 생성

<img width="434" alt="image" src="https://user-images.githubusercontent.com/102898794/199518403-c7fecdba-d6cd-493a-9bfc-c9143d04b0e5.png">

- String 인스턴스의 주소 등가비교연산자’==’로 비교
    - 생성자를 사용해서 문자열을 만든 경우 다른 주소로 할당되기 때문에 false가 나옴
- equals()로 비교
    - 내용을 비교하기때문에 두 방법 모두 true 가 나옴

⇒ ***문자열 비교는 equals()로 비교***
<br/>

### 문자열 리터럴(String 리터럴)

- 문자열 리터럴은 프로그램 실행시 자동으로 생성된다(constant pool에 저장)
- 자바 소스 파일에 포함된 문자열 리터럴은 컴파일 시에 클래스 파일에 저장
    - 이때 같은 내용 문자열 리털럴은 한번만 저장
    ⇒ 문자열 리터럴도 String인스턴스, 
        한번 생성하면 내용을 변경할 수 없으니 하나의 인스턴스를 공유하면 되기 때문에
<br/>

### 빈 문자열 (” “, empty String)

- 내용이 없는 문자열
- 크기가 0인 char형 배열을 저장하는 문자열
    
    `String str = ””; // str을 빈 문자열로 초기화`
    
- 크기가 0인 배열을 생성하는 것은 어느타입이나 가능(int, char..)
`char[] chArr = new char[0];`
`int[] iArr = {};`
- **문자(char)와 문자열(String)의 초기화** 할 때 쓰임(기본값대신)
<br/>

### String 클래스의 생성자와 메서드

> 생성자
> 
- String(char[] value)
    - 문자열 → String
        
        ```java
        char[] c = { 'H','e','l','l','o'};
        String s = new String(c);
        // s = "Hello"
        ```
        
        - 참고  : String→문자열 (toCharrArray())
- String(StringBuffer buf)
    - StringBurffer → String
        
        ```java
        StringBuffer sb = new StringBuffer("Hello");
        String s = new String(sb);
        // s = "Hello"
        ```
        

> 메서드
> 
- char `charAt`(int index)
    - 문자 1개 반환
        
        ```java
        String s = "Hello";
        String n = :"123";
        char c = s.charAt(1);
        char c2 = n.charAt(1);
        // c = 'e'  c2 = '2'
        ```
        
- int `compareTo`(String str)
    - 사전순서로 비교(같으면 0, 이전이면 -, 이후면 +)
        
        ```java
        int i = "aaa".compareTo("aaa");  //i = 0
        int i2 = "aaa".compareTo("bbb"); //i2 = -1
        int i4 = "bbb".compareTo("aaa"); //i3 = 1
        ```
        
- String `concat`(String str)
    - 문자열 뒤에 덧붙임
        
        ```java
        String s = "Hello";
        String s2 = s.concat("World");  // s2 = "HelloWorld"
        ```
        
- boolean `contains`(CharSequence s)
    - 지정된 문자열이 포함되어있는지 검사
        
        ```java
        String s = "abcdef";
        boolean v = s.contains("bc"); //true 
        ```
        
    - CharSequences는 인터페이스
        - charBuffer,Segment,String,StringBuffer,StringBuilder 모두 char[]를 사용하지만 같은 조상이 없어서 쓸때 불편
        - 하지만 모두 CharSequences 쓰기 때문에 사용할때 CharSequences인터페이스 사용하면됨
            - 인터페이스 장점
            : 서로 관계없는 클래스들의 관계를 맺어줄 수 있다.
- boolean `endsWith`(string suffix)
    - 지정된 문자열로 끝나는지 검사
        
        ```java
        String file = "Hello.txt";
        boolean v = file.endsWith("txt"); //true 
        ```
        
- boolean `equalsIgnoreCase`(Object obj)
    - 문자열 대소문자 상관없이 비교
- int `indexOf`(int ch)
    - 문자열에 문자 존재하는지와 index(위치) 알려줌(없으면 -1)
        
        ```java
        String s = "Hello";
        int idx1 = s.indexOf('o') //idx1 = 4
        int idx2 = s.indexOf('k') //idx2 = -1
        ```
        
- int `indexOf`(int ch, int pos)
    - 주어진 문자가 문자열에 존재하는지 pos부터 확인하여 위치 알려줌(없으면 -1)
    - pos는 검색 시작 위치
        
        ```java
        String s = "Hello";
         int idx1 = s.indexOf('e',0); //idx1 = 1;
         int idx2 = s.indexOf('e',2); //idx2 = -1;
        ```
        
- int `indexOf`(String str)
    - 주어진 문자열이 존재하는지 확인하여 index알려줌(없으면 -1)
        
        ```java
        String s = "ABCD";
        int idx = s.indexOf("CD"); //idx =2
        ```
        
- int `lastIndexOf`(int ch)
    - 문자열 오른쪽 끝부터 찾아서 index 알려줌(없으면 -1)
        
        ```java
        String s = "java.lang.Object";
        int idx1 = s.lastIndexOf(','); //idx1 = 9
        int idx2 = s.IndexOf(',');     //idx2 = 4
        ```
        
- int `lastIndexOf`(String str)
    - 문자열 오른쪽 끝부터 찾아서 index 알려줌(없으면 -1)
        
        ```java
        String s = "java.lang.Object";
        int idx1 = s.lastIndexOf('java'); //idx1 = 10
        int idx2 = s.IndexOf('java');     //idx2 = 0
        ```
        
- int `length`()
    - 문자열 길이
- String[] `split`(String regex)
    - 문자열 배열에 담아 반환
- String[] `split`(String regex, int limit)
    - 문자열 배열에 담아 반환 하는데 몇 부분으로 나눌것인지 지정
        
        ```java
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");  //arr[0]="dog"/arr[1]="cat"/arr[2]="bear"
        String[] arr = animals.split(",",2);//arr[0]="dog"/ arr[1]="cat,bear"
        ```
        
- boolean `startsWith`(String prefix)
    - 주어진 문자열로 시작하는지 검사
        
        ```java
        String s = "java.lang.Object";
        ********************boolean b = s.startsWith("java"); //b=true
        boolean b2 = s.startsWith("lang"); //b2=false
        ```
        
- String `substring`(int begin) / String substring(int begin, int end)
    - begin부터 end 범위에 포함된 문자열을 얻는다.
        
        ```java
        String s = "java.lang.Object";
        String c = s.substring(10) // c = "Object"
        String p = s.substring(5,9)// p = "lang"
        ```
        
- String `toLowerCase`()
    - 모든문자열 소문자로
- String `toUpperCase`()
    - 모든문자열 대문자로
- String `trim`()
    - 문자열 왼쪽 끝과 오른쪽 끝에 있는 공백 없앤 결과 반환
- String `valueOf`(기본형)
    - 기본형을 모두 문자열로 반환
    - `+ “ ”` 로 해줘도 되지만 `valueOf`가 성능이 더 빠름
    
<br/>

### join()과 StringJoiner(jdk 1.8부터 추가)

- join() : 여러 문자열 사이에 구분자를 넣어서 결합 (split와 반대 개념)
    - 내부적으로 stringBuffer을 사용해서 속도를 향상시키도록 코드 작성되어있음
        - 많은 문자열 결합시 사용하면 좋음
    
    ```java
    String animals = "dog,cat,bear";
    String arr[] = animals.split(",");
    String str = String.join("-",arr); //str = "dog-cat-bear"
    ```
    
- StringJoiner
    - java.util.StringJoiner클래스를 사용해서 문자열을 결합
    
    ```java
    StringJoiner sj = new StringJoiner(",","[","]");
    String[] strArr = { "aaa","bbb","ccc"};
    for(String s : strArr)
    		sj.add(s.yoUpperCase()); //sj.toString = "[AAA,BBB,CCC]"
    ```
 <br/>
   

### 문자열과 기본형 간의 변환

- 기본형 → 문자열
    1. 기본형 +””
    2. String.valuaOf(기본형)
- 문자열 → 기본형
    1. 기본형.parse기본형(String str)
        
        <img width="256" alt="image" src="https://user-images.githubusercontent.com/102898794/199518667-882a089e-090f-4b68-9ee8-b9ffb70efdcc.png">
        
    2. `valueOf`()로 통일 
        1. Interger.`valueOf`(String str)
        - valueOf로 바꾸면 참조형인 Integer로 반환되지만 오토박싱에 의해 참조형이 기본형으로 자동변환해줘서 상관 안하고 써도 된다.
        
<br/>

## StringBuffer클래스

- 문자열을 저장하고 다루기 위한 클래스
- String처럼 문자열 배열(char[])을 내부적으로 가지고 있음
    
    ```java
    public final class stringBuffer implements java.io.Serializable{
    	private char[] value;
    		...
    }
    ```
    
    - Stringbuffer인스턴스가 생성될 때, char형 배열이 생성되며 이 때 생성된 char형 배열을 인스턴스변수 value가 참조하게 된다.

- String가 달리 내용을 변경할 수 있다(mutable)
    
    <img width="405" alt="image" src="https://user-images.githubusercontent.com/102898794/199518807-8f2b39dc-d7a2-4e16-9966-f9e620ab4f47.png">
<br/>

### StringBuffer의 생성자

- 배열은 길이 변경불가. 공간이 부족하면 새로운 배열 생성해야
    1. 새로운 배열 생성
    2. 내용복사
    3. 참조변경
- StringBuffer클래스의 인스턴스 생성할 때
    - 적절한 길이의 char형 배열이 생성되고, 이 배열은 문자열을 저장하고 편집하기 위한 공간으로 사용
- StringBuffer인스턴스에 저장될 문자열의 길이를 고려하여 충분히 여유있는 크기로 지정하는 것이 좋음
- StringBuffer인스턴스 생성할때, 버퍼의 크기를 지정해주지 않으면 16개의 문자를 저장할 수 있는 크기의 버퍼를 생성

  <img width="510" alt="image" src="https://user-images.githubusercontent.com/102898794/199518931-4a6ab730-8666-40de-bd0a-1ab8bf7d3b95.png">
<br/>

### StringBuffer의 변경

- StringBuffer는 String가 달리 내용 변경이 가능(append, delete, insert)
- `반환타입 StringBuffer`
    - 주소 반환 됨(그래서 밑에 코드가 가능)
        
        <img width="640" alt="image" src="https://user-images.githubusercontent.com/102898794/199519157-e32adc27-f1d2-4654-85c1-d6ed7c294dbb.png">
        
<br/>

### StringBuffer의 비교

- StringBuffer는 equals()가 오버라이딩되어있지 않음(주소비교)
- **String으로 변환 후에 equals()로 비교해야한다**

<img width="473" alt="image" src="https://user-images.githubusercontent.com/102898794/199519288-c2da73d2-e780-4dc4-b3be-2ebab8bbe732.png">
<br/>

### StringBuffer의 생성자와 메서드

- 생성자
    1. StringBuffer()
        1. 16문자 담을 수 있는 공간 생성
            
            ```java
            Stringbuffer sb = new StringBuffer();
            ```
            
    2. StringBuffer(int length) ⇒ **베스트(불필요한 배열이 생기지 않으니까)**
        1. 원하는 버퍼를 가진 stringBuffer인스턴스 생성
    3. StringBuffer(String str)
        1. str길이 +16 자리의 버퍼 생김

> 메서드
> 
- `append`
    - 매개변수로 입력된값 문자열로 변환하여 저장하고 있는 문자열 뒤에 덧붙인다
- int `capacity`()
    - StingBuffer인스턴스의 char[] 버퍼크기를 알려준다
    - (length()는 버퍼에 담긴 문자열의 길이를 알려준다)
- char `charAt`(int index)
    - index에 있는 문자 반환
- StringBuffer `delete`(int start, int end)
    - start부터 end전까지 지워줌
- StringBuffer `deleteCharAt`(int idx)
    - idx자리에 있는 문자 제거
- StringBuffer `insert`(int pos, a(어떤걸 삽입할건지))
    - pos 자리에 있는 문자를 a를 삽입
- StringBuffer `replace`(int start, int end, String str)
    - start부터 end전까지와 str을 치환해준다
- StringBuffer `reverse`()
    - 문자열 뒤집기
- void `setCharAt`(int index, char ch)
    - 지정된 index에 있는 문자를 주어진 문자(ch)로 바꾼다.
- void `setLength`(int newLength)
    - newLength로 길이 변경
        - 만약 지금 길이 보다 짧으면 없애고, 길면 null값(공백) 넣어준다
- String `toString`()
    - StringBuffer→String
- String `substring`(int start) / String substring(int start, int end)
    - start부터 end전까지 문자 뽑아준다
<br/>

### StringBuilder

- StringBuffer  동기화o
- StringBuilder 동기화x

- 멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하
    
    ⇒ 싱글쓰레드프로그램 쓸때 `StringBuffer 대신 StringBuilder를 사용하면 성능향상`
    
- Stringbuffer도 충분히 성능이 좋기에 성능향상이 반드시 필요한 경우 제외하고는 굳이 바꿀 필요x

```java
🐳 동기화→ 데이터 보호/ 멀티 쓰레드에 안전
🐳 멀티쓰레드 : 동시에 여러작업 / 싱글쓰레드 : 한번에 1개 작업
```
