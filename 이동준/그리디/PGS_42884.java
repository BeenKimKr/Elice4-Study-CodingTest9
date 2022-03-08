import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        /*
        일단 경로들을 정렬해두고 맨앞에 카메라를 하나 단다고 생각하자
        그리고 경로 하나씩 보면서 많이 겹칠수 있는 위치까지 카메라를 옮기고
        안이어진다면 카메라를 추가
        */
        //l,r은 겹치는 부분의 왼쪽끝 오른쪽끝
        int answer = 1,l,r;
        Arrays.sort(routes, (o1,o2)->o1[0]-o2[0]);
        l=routes[0][0]; r=routes[0][1];
        for(int i=1;i<routes.length;i++){
            int tmpl=routes[i][0],tmpr=routes[i][1];
            
            if(r<tmpl){//경로가 겹치지 않는 경우 l,r 새로 설정
                answer++; r=tmpr; l=tmpl;
            }else{
                l=tmpl;
                if(tmpr<r)//지금 보고있는 tmpl 더 작으면 r을 땡겨줌 
                    r=tmpr;
            }
        }
        return answer;
    }
}