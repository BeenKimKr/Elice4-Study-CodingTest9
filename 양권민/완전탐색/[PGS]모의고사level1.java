import java.util.*;

//테스트 케이스 6~13 실패

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        map.put(1, check(one,answers));
        map.put(2, check(two,answers));
        map.put(3, check(three,answers));
        
        //가장 높은 점수를 받은 사람 찾기
        int maxValue = Collections.max(map.values());
		for(Map.Entry<Integer, Integer> m : map.entrySet()) {
			if(m.getValue()==maxValue) {
				answer.add(m.getKey());
			}
		}
        
        //오름차순 정렬
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
    
    //맞은 갯수 체크해주는 함수
    public int check(int[] supo, int[] answers) {
        int idxNum = 0;
        int idxAnswer = 0;
        int count = 0;
        
        while(true) {
            if(idxAnswer == answers.length) break;
            
            else if(idxNum == supo.length) {
                idxNum = 0;
                continue;
            }
            
            else if(supo[idxNum] == answers[idxAnswer]) {
                count++;        
            } 
            idxNum++;
            idxAnswer++;
        }
        return count;
    }
}