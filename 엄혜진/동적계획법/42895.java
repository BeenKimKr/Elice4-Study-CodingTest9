// 2022. 03. 07
// N으로 표현
// 미해결: DP에 대한 이해도 부족... 
// 참고한 글: https://velog.io/@rari_1110/DFS-프로그래머스-N으로-표현-JAVA, https://small-stap.tistory.com/65, 

// class Solution {
//     int answer;
//     public int solution(int N, int number) {
//         //모든 최솟값이 8보다 커서 dfs가 return 되는 경우는 답이 -1
//         answer = -1;
        
//          DFS(N, number, 0, 0);
        
//         return answer;
//     }
    
//     public void DFS(int N, int number, int sum, int count){
//         if(count > 8) return;
        
//         if(sum == number){
//             if(count < answer || answer == -1) answer = count;
//             return;
//         }
//         //새로운 DFS를 탈 때 tmpN을 초기화시켜줌으로써 N, NN, NNN 등을 탐색할 수 있다
//         int tmpN = 0;
//         for(int i=1; i<9; i++){
//             tmpN = tmpN*10 + N;
//             DFS(N, number, sum+tmpN, count+i);
//             DFS(N, number, sum-tmpN, count+i);
//             DFS(N, number, sum*tmpN, count+i);
//             DFS(N, number, sum/tmpN, count+i);
//         }
        
//     }
// }