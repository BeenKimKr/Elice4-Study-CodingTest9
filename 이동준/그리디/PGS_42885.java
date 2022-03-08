import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        //제일 무거운놈이랑 제일 가벼운 놈이랑 짝?
        Arrays.sort(people);
        // for(int i : people)
        //     System.out.printf(i+" ");
        
        int answer = 0;
        int min=0,max=people.length-1,save=0;
        while(save<people.length){
            if(people[min]+people[max]<=limit){
                min++; max--;
                save+=2; answer++;
            }else{
                save++; answer++; max--;
            }
        }
        return answer;
    }
}