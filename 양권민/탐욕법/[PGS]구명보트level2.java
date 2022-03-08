import java.util.*;
//미해결 런타임 에러, 효율성 에러


class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> peopleList = new ArrayList<>();
        
        for(int i: people) {
            peopleList.add(i);
        }
        //내림차순 정렬
        Collections.sort(peopleList, Collections.reverseOrder());        
        
        int tempIdx = 1;
        
        while(true) {
            if(peopleList.size() <= 2) {
                if(peopleList.size() == 0) break;
                
                else if(peopleList.size() == 1) {
                    answer++;
                    break;
                }
                else {
                    int bigNum = peopleList.get(0);
                    int smallNum = peopleList.get(1);
                    if(bigNum + smallNum <= limit) {
                        answer++;
                        break;
                    }
                    else {
                        answer += 2;
                        break;
                    }
                }
            }
            else {
                if(tempIdx == peopleList.size()){
                    peopleList.remove(0);
                    tempIdx = 1;
                    answer++;
                    continue;
                }
                int bigNum = peopleList.get(0);
                int smallNum = peopleList.get(tempIdx);
                if(bigNum + smallNum <= limit) {
                    peopleList.remove(0);
                    peopleList.remove(tempIdx);
                    answer++;
                    tempIdx = 1;
                } 
                else {
                    tempIdx++;
                }    
            }   
        }
        return answer;
    }
}