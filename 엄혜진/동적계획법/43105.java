// 2022. 03. 07
// 정수 삼각형
// 미해결: DP에 대한 이해도 부족... 

class Solution {
    public int solution(int[][] triangle) {
        // 행에서 최댓갑을 찾고, 이전 행에서 이동할 수 있는지 여부를 판단했지만,
        // 이 방법은 그때 그때 최선의 값을 찾을 뿐, 궁극적으로 최댓값을 찾지 못한다.
        // int answer = triangle[0][0];
        // int preIdx = 0;
        
        // for(int i = 1; i < triangle.length; i++) {
        //     int maxInRow = 0;
        //     for(int j = 0; j < triangle[i].length; j++) {
        //         if(maxInRow < triangle[i][j]) {
        //             if(j - 1 ==  preIdx || j + 1 == preIdx) {
        //                 maxInRow = triangle[i][j];
        //                 preIdx = j;   
        //             }
        //         }
        //     }
        //     System.out.println(preIdx);
        //     answer += maxInRow;
        // }
        
        return answer;
    }
}