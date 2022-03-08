// 2022. 02. 14
// 모의고사

import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        
        // 수포자의 문제 찍는 방식
        int[][] spj = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 맞힌 문제 개수 카운트
        int[] correctCount = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) {
            // 1번 수포자
            if(answers[i] == spj[0][i % spj[0].length]) {
                correctCount[0]++;
            }
            
            // 2번 수포자
            if(answers[i] == spj[1][i % spj[1].length]) {
                correctCount[1]++;
            }
            // 3번 수포자
            if(answers[i] == spj[2][i % spj[2].length]) {
                correctCount[2]++;
            }
        }
        
        // 가장 많이 맞힌 사람
        int middleResult = (correctCount[0] > correctCount[1]) ? 0 : 1;
        int finalResult = (correctCount[middleResult] > correctCount[2]) ? middleResult : 2;
        System.out.println(finalResult);
        int correctSpjCount = 0;
        answer[correctSpjCount] = finalResult + 1;
        
        // 동일한 점수를 가지고 있는 사람
        for(int i = 0; i < correctCount.length; i++) {
            if(correctCount[i] == correctCount[finalResult] && i != finalResult) {
                answer[++correctSpjCount] = i + 1;
            }
        }
        
        answer = Arrays.copyOfRange(answer, 0, correctSpjCount + 1);
        Arrays.sort(answer);
        
        return answer;
    }
}