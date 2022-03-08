import java.util.*;
class Solution {
    public int solution(int[] money) {
        //이전에 한거는 사실 브루트포스로다가 했고 당연히 메모리초과 시간초과뜸
        //거기다가 메모이제이션을 해줄라 했는데 모든 경우를 다 보는 거여서 중복된 연산이 없음
        //dp로 바꿔줄수가 없어서 걍 답지봄
        
        //https://programmers.co.kr/questions/12213
        //재귀로 하는건데 처음에 이렇게 하려다가 때려침..
        
        //오늘의 깨달은점 무조건 재귀가 좋은건 아니다 그렇다고 무조건 반복문이 좋은것도 아님
        //개인적으로는 반복문이 직관적이고 이해가 빠른데 재귀는 내부적으로 돌아가는걸 이해하는데 좀 오래걸림
        //코드 길이는 재귀가 조금더 짧은듯? 대체적으로
        //근데또 재귀로 해야 안복잡한 경우도 있음 그 저번에 순열 구현하는거 같은 경우 반복문만으로는 너무 복잡해짐
        //아무튼 상황에 따라 적절히 섞어쓰자..
        
        int answer = 0;
        int len=money.length;
        int[] dp=new int[len]; //해당 위치에서의 최대값
        dp[1]=money[1]; //첫집 안턴 경우
        for(int i=2;i<len;i++){
            dp[i]=Math.max(money[i]+dp[i-2],dp[i-1]); //현재집 털 경우, 안털 경우
        }
        answer=dp[len-1];
        Arrays.fill(dp,0);
        dp[0]=money[0]; //첫집 턴 경우     
        dp[1]=money[0];//Math.max(money[0],money[1]); 
        //참고한 코드는 max를 뜬금없이 쓰던데 아무리 생각해도 잘못쓴듯 내가한게 맞다..
        for(int i=2;i<len-1;i++){ //첫집 털어서 마지막집은 못털음 그래서 마지막 dp는 없음
            dp[i]=Math.max(money[i]+dp[i-2],dp[i-1]); //현재집 털 경우, 안털 경우
        }
        answer=Math.max(answer,dp[len-2]);
        return answer;
    }
}