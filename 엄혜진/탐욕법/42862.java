// 2022. 02. 20
// 체육복

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] cloth = new int[n];
        
        // 가지고 있는 체육복 총 개수 확인
        for(int i = 0; i < n; i++) {
            cloth[i] = 1;
        }
        
        for(int i = 0; i < lost.length; i++) {
            cloth[lost[i] - 1] -= 1;
        }
        
        for(int i = 0; i < reserve.length; i++) {
            cloth[reserve[i] - 1] += 1;
        }
    
        // 옷을 0개 가지고 있으면 앞, 뒤 사람을 확인해서 1로 만들기
        for(int i = 0; i < n; i++) {
            if(cloth[i] == 0) {
                // 앞 확인
                if(i > 0) { // 0번째 사람의 앞 사람은 없음
                    if(cloth[i - 1] > 1) {
                        cloth[i - 1] -= 1;
                        cloth[i] += 1;
                        continue;
                    }
                }
                // 뒤 확인
                if(i < n - 1) { // n-1번째 사람의 뒷 사람은 없기 때문에 넣은 조건문인데, 인덱스를 잘못 지정해서 런타임에러났음...
                    if(cloth[i + 1] > 1) {
                        cloth[i + 1] -= 1;
                        cloth[i] += 1;
                    }  
                } 
            }   
        }
        
        for(int i = 0; i < n; i++) {
            if(cloth[i] < 1) {
                answer--;
            }
        }
        
        
        return answer;
    }
}