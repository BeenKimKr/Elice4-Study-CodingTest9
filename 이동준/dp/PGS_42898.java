import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp=new int[n][m]; //해당 위치까지 갈수 있는 최단 경로 개수
        
        //웅덩이는 -1로 
        for(int i=0;i<puddles.length;i++){
            int x=puddles[i][0]-1,y=puddles[i][1]-1;
            dp[y][x]=-1;
        }
        
        //홀리몰리한 경우참고.. 그니까 1행 또는 1열에 물 있는 경우 따져줘야함
        for(int i=0;i<n;i++){
            if(dp[i][0]==-1)
                break;
            dp[i][0]=1;
        }
        for(int i=0;i<m;i++){
            if(dp[0][i]==-1)
                break;
            dp[0][i]=1;
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j]!=-1){
                    int up=dp[i-1][j],left=dp[i][j-1];
                    if(up==-1)
                        up=0;
                    if(left==-1)
                        left=0;
                    dp[i][j]=(up+left)%1000000007;
                }
            }
        }
        
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.printf(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        int answer = dp[n-1][m-1];
        return answer;
    }
}