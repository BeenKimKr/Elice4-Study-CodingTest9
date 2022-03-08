import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        //맨윗줄부터 직접 가면서 해당 위치에서의 경로 최대값 저장
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    triangle[i][j]+=triangle[i-1][j];
                }else if(j==i){
                    triangle[i][j]+=triangle[i-1][j-1];
                }else{
                    triangle[i][j]+=Math.max(triangle[i-1][j],triangle[i-1][j-1]);
                }
            }
        }
        
        //마지막줄 최대값찾기
        for(int i=0;i<triangle.length;i++){
            answer=Math.max(answer,triangle[triangle.length-1][i]);
        }
        return answer;
    }
}