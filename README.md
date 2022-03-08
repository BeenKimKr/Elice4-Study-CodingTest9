# Elice4-Study-CodingTest9

엘리스 4기 코딩테스트 스터디 9팀 레포지토리입니다.

---

## 🏃🏻 [참여자](https://github.com/hyejineom-dev/elice4-Study-CodingTest9/graphs/contributors)

<table>
  <tr>
    <td align="center"><a href="https://github.com/BeenKimKr"><img src="https://avatars.githubusercontent.com/u/96720480?v=4?s=100" width="100px;" alt=""/><br /><sub><b>KyungBeen</b></td>
    <td align="center"><a href="https://github.com/gwonmin"><img src="https://avatars.githubusercontent.com/u/65943751?v=4?s=100" width="100px;" alt=""/><br /><sub><b>gwonmin</b></td>
    <td align="center"><a href="https://github.com/hyejineom-dev"><img src="https://avatars.githubusercontent.com/u/40953167?v=4?s=100" width="100px;" alt=""/><br /><sub><b>hyejin</b></td>
    <td align="center"><a href="https://github.com/Ldj-git"><img src="https://avatars.githubusercontent.com/u/68588092?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Ldj</b></td>
    </tr>
</table>

---

## 🗓 진행 기간

2022년 1월 25일 ~ 2022년 3월 11일

---

## 📐 진행 방식

### 1️⃣ [프로그래머스 고득점 KIT](https://programmers.co.kr/learn/challenges?tab=algorithm_practice_kit) 문제 풀기

| 스터디 기간         | 이번 주 목표       | 미팅 날짜                |
| ------------------- | ------------------ | ------------------------ |
| 1월 25일 ~ 1월 29일 | 해시, 스택/큐      | (설연휴로 2주차 때 진행) |
| 2월 8일 ~ 2월 12일  | 힙, 정렬          | 2월 7일                  |
| 2월 15일 ~ 2월 19일 | 완전탐색          | 2월 14일                 |
| 2월 22일 ~ 2월 26일 | 탐욕법(1)         | 2월 21일                 |
| 3월 1일 ~ 3월 5일   | 탐욕법(2)         | 2월 28일                 |
| 3월 8일 ~ 3월 12일  | 동적계획법         | 3월 7일                  |
<!-- 동적계획법, 깊이/너비 우선탐색, 이분탐색, 그래프 -->
### 2️⃣ 깃허브에 코드 공유

0. [깃허브를 이용한 알고리즘 스터디 하는법](https://waytocse.tistory.com/59) 참고
1. fork
2. fork한 레포에 폴더 생성
3. 코드 업로드 & 커밋
4. PullRequest

### 3️⃣ 매주 월요일 오후 9시에 모여서 문제 푼 거 확인 & 담당한 문제 풀이

- [네이버 사다리타기](https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EC%82%AC%EB%8B%A4%EB%A6%AC%ED%83%80%EA%B8%B0)로 설명할 문제 할당

- 관련 코테 문제 공유 환영!!!

---

## 📓 스터디 미팅 기록

### 🔸 1월 24일
#### 미팅 참여자
: 김경빈, 김영성, 양권민, 엄혜진, 이동준
#### 미팅 내용
- 스터디 방식 논의
- 깃허브 레포지토리 생성


### 🔸 2월 7일
#### 미팅 참여자
: 김경빈, 김영성, 엄혜진, 이동준
#### 이번 주 문제: 해시, 스택/큐, 힙, 정렬
#### 미팅 내용
- 자바 문법
  - [Integer.toString()](https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html)
  - [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)
  - [PriorityQueue](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html)
#### 다음 주 문제
- 이번 주 부터 문제 개수 변경: 3개


### 🔸 2월 14일
#### 참여자
: 김경빈, 양권민, 엄혜진, 이동준

#### 이번 주 문제: 완전탐색
#### 미팅 내용
- 42840번 문제: 모의고사
  - 맞힌 문제 카운트 구현 부분에서 패턴의 길이가 상이한 점 핸들링
    - 방법 1: 패턴을 1차원 배열 3개로 만들어서, 각 배열의 길이 값으로 패턴 인덱스 조정 (코드 가독성 굿...👍)
    - 방법 2: 패턴을 2차원 배열 1개로 만들고, 각 패턴의 인덱스를 따로 선언해서 조정
- 42839번 문제: 소수 찾기
  - [순열](https://bcp0109.tistory.com/14?category=848939)
- 42942번 문제: 카펫
  - 방법 1: 카펫 사이즈를 소인수분해해서 조건에 맞는 가로, 세로 구하기
  - 방법 2: 가로, 세로가 될 수 있는 모든 경우의 수에서 조건에 부합하는 것 찾기
  - 방법 3: 옐로우의 가로, 세로 값과 브라운의 개수 값의 연관성으로 조건에 부합하는 것 찾기
#### 다음 주 문제
- 탐욕법(체육복, 조이스틱, 큰 수 만들기)


### 🔸 2월 21일
#### 참여자
: 양권민, 엄혜진, 이동준

#### 이번 주 문제: 탐욕법
#### 미팅 내용
- 42862번 문제: 체육복
- 42839번 문제: 조이스틱
  - [동준님이 공유한 획기적인 조이스틱 풀이법](https://velog.io/@jeeseob5761/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1)
- 42883번 문제: 큰 수 만들기
  - Java에서 String은 immutable이기 때문에 [substring](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#substring(int))을 써도 수정이 어렵다. 대신에 [StringBuilder](https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html), [StringBuffer](https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuffer.html)를 사용하자.
  - [substring에 대한 인터뷰 이야기..](https://javarevisited.blogspot.com/2011/10/how-substring-in-java-works.html#axzz7LXKffYXx)
  - [String vs. StringBuffer vs. StringBuilder](https://coding-factory.tistory.com/546)
#### 다음 주 문제
- 탐욕법(구명보트, 섬 연결하기, 단속카메라)


### 🔸 2월 28일
#### 참여자
: 김경빈, 엄혜진, 이동준

#### 이번 주 문제: 탐욕법
#### 미팅 내용
- 42885번 문제: 구명보트
  - 제일 무거운 사람과 가벼운 사람을 짝지어서 태우기(짝 지을 수 없다면 현재 제일 무거운 사람보다 덜 무거운 사람과 짝지어보기)
- 42861번 문제: 섬 연결하기
  - 최소신장트리
    1. 프림 알고리즘: 엣지가 많은 그래프에 유리
    2. 크루스칼 알고리즘: 엣지가 적은 그래프에 유리
       - [동준님이 공유한 Union Find 구현 방법](https://ssungkang.tistory.com/198) + 부모노드를 한번에 찾을 수 있도록 해서 효율높이기
- 42884번 문제: 단속카메라
  - 동준님의 세션
    - 주어진 데이터를 한 번만 읽기
    - 범위를 이용해서 가장 많이 겹친 곳에 카메라 설치하기
#### 다음 주 문제
- 동적계획법(N으로 표현, 정수 삼각형, 등굣길, 도둑질)


### 🔸 3월 7일
#### 참여자
: 김경빈, 엄혜진, 이동준

#### 이번 주 문제: 동적계획법
#### 미팅 내용
- 42895번 문제: N으로 표현
  - [잘게 쪼개서 생각하는 것에 도움이 된 글](https://small-stap.tistory.com/65)
    - 괄호도 경우의 수를 나눠서 해결
- 43105번 문제: 정수 삼각형
  - 동준님이 푼 방법: 좌측과 우측은 정해져 있고 가운데에 위치한 원소들의 모든 경우의 수를 확인하기
  - 경빈님이 푼 방법: 각 인덱스로 모든 경우의 수를 확인하고 최댓값 찾기
  - 탐욕법으로 해결할 수 없는 문제였다...
- 42898번 문제: 등굣길
  - 동준님이 푼 방법: 첫번째 행은 모두 1, 각 행의 첫번째 열은 1로 하고, 웅덩이는 0으로 넣어서 풀기
    - 단, [홀리몰리한 테스트케이스 대처방법](https://programmers.co.kr/questions/24593)을 참고해야한다.
- 42897번 문제: 도둑질
  - 동준님이 푼 방법: 각 집을 턴 경우를 모두 배열로 만들어서(단, 계산된 것들을 활용하기) 최대값을 갖는 배열 구하기
#### 1차 스터디를 마무리하며...
- 스터디 연장?
  - 2차 스터디 진행 시 참여하기
- 회고
  - 스터디원 참여가 부족했다.
  - 스터디원 참여도 향상에 적절하지 못한 문제 개수였다.
    - ❗️ 일주일에 1~2개가 좋은 거 같다.
  - 난이도 조절에 실패해서 스터디에 지나치게 시간을 할애해야하는 경우도 있었다.
    - ❗️ 1시간 고민해보고 다른 코드를 익히고 '본인의 것'으로 만들기(안 보고 풀어보기)
  - 코테에 익숙해지기 시작한거 같다.
  - 자바 언어에 익숙하지 않았다.
- 🎯 회고 결론
  1. 스터디원 참여도 향상을 위해 문제 개수 조절, 난이도 조절이 필요하다.
  2. 문제를 풀었는지에 대해 논의하기보다, 서로의 코드에 대해 의논하는 방향으로 진행해야 한다.