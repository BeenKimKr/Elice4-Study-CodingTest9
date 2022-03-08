class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] std= new int[n];
        //조건에 맞게 채우기
        for(int i=0;i<n;i++)
            std[i]=1;
        for(int i :lost)
            std[i-1]--;
        for(int i : reserve)
            std[i-1]++;
        
        int l=0,r=n-1; //왼쪽끝 오른쪽끝 인덱스
        while(l<=r){
            if(std[l]==2&&std[l+1]==0){//본인이 여분이 있고 옆사람이 없을때
                std[l]--; std[l+1]++;
            }
            if(std[l]==0&&std[l+1]==2){//본인이 없고 옆사람이 여분이 있을때
                std[l]++; std[l+1]--;
            }
            if(std[r]==2&&std[r-1]==0){//본인이 여분이 있고 옆사람이 없을때
                std[r]--; std[r-1]++;
            }
            if(std[r]==0&&std[r-1]==2){//본인이 없고 옆사람이 여분이 있을때
                std[r]++; std[r-1]--;
            }
            l++; r--;
        }
        
        for(int i : std){
            if(i>0)
                answer++;
        }
            
        return answer;
    }
}