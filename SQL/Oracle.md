# 오라클 공부

- 오라클 사용하려면 tnsnames.oRA에 사용할 서버 정보 적혀 있어야함
- NET Manage에서 서버 정보 확인 후
- 그 정보를 이용해서 서버 연결

## 별칭

```sql
SELECT  empno as 사원번호, ename as 사원이름, sal as "Salary"
  FROM emp;
```

- “” 붙여줘야하는 경우
    - 대소문자 구분할때
    - 공백, 특수문자($,_#) 출력할 때
    
- 붙여서 쓸때  (||)

```sql
SELECT ename || sal
  FROM emp;
```

- 중복된 데이터 제거 (`DISTINCT` or `UNIQUE`)

- 가져오는 테이블 없을때 `FROM DUAL;` 붙여줘야함

> 대소문자 변환 (UPPER, LOWER, INITCAP)
> 
- UPPER : 대문자로
- LOWER : 소문자로
- INITCAP : 첫번째 문자만 대문자

> 문자 추출
> 
- 문자에서 특정 철자 추출(SUBSTR) → 1부터 시작

```sql
SUBSTR('SMITH',1,3)   -- SMI
SUBSTR('SMITH',-2,2)  -- TH
SUBSTR('SMITH',2)     -- MITH
```

- 문자에서 특정 철자 위치 출력 (INSTR)
    - INSTR(’SMIRTH’,’M’) → 2
- 특정 철자를 다른 철자로 변경 (REPLACE )
    - REPLACE(테이블 명 , 0, ’*’)→ 0이 *으로 변경
    - REGEXP_REPLACE(테이블명, ‘[0-3]’, ’*’) → 0,1,2,3이 *로 변경
        - REGEXP_REPLACE → 정규식
- 특정 철자를 N개 만큼 채우기 (LPAD, RPAD)
    - LPAD(테이블 명, 자릿수, ‘*’)→ 비어진 자릿수만큼 앞에 ‘*’ 채움
    - RPAD(테이블 명, 자릿수, ‘*’)→ 비어진 자릿수만큼 뒤에 ‘*’ 채움
        - 예외(
        
        ```sql
        SELECT ename, sal,RPAD('◆', round(sal/100), '◆') as bar_chart
        FROM emp;
        ```
        
        ![image](https://user-images.githubusercontent.com/102898794/221446370-219544c2-d1a6-4c23-84a7-617a07a4a050.png)

        
- 특정 철자 잘라내기(TRIM, RTRIM, LTRIM)
    - TRIM(’s’ from ‘smiths’)  → mith 양쪽
    - RTRIM(’smith’,’h’)          → smit  오른쪽
    - LTRIM(’smith’,’s’)           → mith 왼쪽
    

> 숫자
> 
- 반올림 (ROUND)
    - ROUND(3423.362,1) → 3423.4(일의 자리까지 반올림)
- 숫자 버리고 출력(TRUNC)
    - TRUNC(876.567,1) → 876,5
    - TRUNC(876.567,0) = TRUNC(876.567) = 876
- 나눈 나머지 값 출력(MOD)
    - MOD(10,3) → 1
- 나눈 몫(FLOOR)
    - FLOOR(10/3) → 3

> 날짜
> 

```sql
** sysdate : 오늘 날짜 확인

** TO_DATE :  몇 일 지났는지 확인 
SELECT TO_DATE('2019-06-01','RRRR-MM-DD') - TO_DATE('2019-02-01','RRRR-MM-DD')
  FROM dual;
--> 120

** 오라클은 문자형과 숫자형 두 개를 비교할 때는 문자형을 숫자형으로 변환
** SET AUTOT ON
	: SQL 실행할 때 출력되는 결과와 SQL 실행 계획을 한 번 보여달라는 SQLPLUS 명령어
```

- 현재 날짜 포맷 확인

```sql
SELECT *
FROM NLS_SESSION_PARAMETERS
WHERE PARAMETER = 'NLS_DATE_FORMAT';

-- 날짜 포맷 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/RR';
```

- 날짜 간 개월 수 출력하기(MONTHS_BETWEN)
    - MONTHS_BETWEN(최신 날짜, 예전 날짜)
- 더한 날짜 출력(ADD_MONTHS)
    - 개월 수
        - `ADD_MONTHS(TO_DATE('2019-06-01','RRRR-MM-DD'),100)`
        → 27/10/01
    - 일
        - `TO_DATE('2019-06-01','RRRR-MM-DD')+100`
- INTERAL을 사용하면 더 섬세하게 날짜 산술 연산 가능
- TO_YMINTERVAL  몇 년 지났는지
    
    ```sql
    SELECT TO_DATE('2019-06-01','RRRR-MM-DD')+ TO_YMINTERVAL('03-05')
      FROM dual;
    -->22/11/01
    ```
    
- 특정 날짜 뒤에 오는 요일 날짜 출력(NEXT_DAY)
    - 2019/05/22 일로부터 바로 돌아오는 목요일 날짜 출력
    
    ```sql
    SELECT '2019/05/22' as 날짜, NEXT_DAY('2019-06-11','목요일')
      FROM DUAL;
    --> 19/06/13
    ```
    
- 특정 날짜가 있는 달의 마지막 날짜 출력하기(LAST_DAY)
    - LAST_DAY('2019-06-11') → 19년 6월의 마지막 날 출력
    - 몇 일 남았는지 알고 싶으면
        - LAST_DAY(SYSDATE) - SYSDATE
    
- 문자형으로 데이터 유형 변환하기(TO_CHAR)
    - 숫자형 데이터 → 문자형
        - 월급 출력할 때 천 단위로 표시
            - to_char(테이블 명 , '999,999')
                - 9는 자릿수로 어떤 숫자가 와도 상관없다는 뜻
            - L붙이면 앞에 $ **표시**
                - to_char(테이블 명 , 'L999,999')
    - 날짜형- > 문자형
        - 날짜에서 년,월,일, 요일 등 추출 가능
    
    ```sql
    SELECT hiredate, TO_CHAR(hiredate,'RRRR') AS 연도 , TO_CHAR(hiredate,'MM') AS 달, TO_CHAR(hiredate,'DD') AS 일,TO_CHAR(hiredate,'DAY') AS 요일
      FROM emp
      where ename='KING';
    ```
    
    ![image](https://user-images.githubusercontent.com/102898794/221446386-bf6ffe75-b7f9-48eb-8ec0-ece0f2bb6891.png)

    

- 날짜 컬럼에서  연도/월/일/시간/분/초 추출( EXTRACT)
    
    ```sql
    SELECT ename as 이름, EXTRACT(year from hiredate) as 년 ,
                         EXTRACT(month from hiredate) as 월,
                         EXTRACT(day from hiredate) as 일
      FROM emp;
    ```
    

> NULL
> 
- NULL값 대신 다른 데이터 출력하기 (NVL, NVL2)
    - comm테이블=null→ 0으로 변경 NVL(comm,0)
        - 계산할 때 용이
    - NVL2(null인 테이블, null이 아닐 때 값, null일 때 넣을 값  )

> 조건문
> 
- IF문을 sql로 구현
1.   DECODE
    - DECODE(deptno,10,300,20,400,0)
        - detno = 10→ 300 , 20→400 , 둘다 아니면 0
2. CASE
    - CASE WHEN 조건 THEN 결과 (ELSE (다 아니면 결과))

- 둘의 차이점은 `DECODE`는 = 만 가능, `CASE`는 =,≥,≤,<,> 가능

> 기본문법
> 
- MAX
- MIN
- AVG  평균
- SUM
- GROUP BY에 조건 절 넣으려면 HAVING
- COUNT
