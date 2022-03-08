import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        //최소 신장 트리.. 방법 유명한거 두가지
        //프림 알고리즘 -> 노드 기준으로 보고 다 연결될때까지 (이 알고리즘도 그리디라고 볼수도 있는듯?)
        //엣지가 많은 dense 그래프 일수록 유리
        //크루스칼 -> 엣지 기준으로 보고 그리디 하게 가장 비용 낮은것만 뽑는데 유니온파인드로 중간에 거르는거(사이클 탐지) 
        //엣지가 적은 sparse 그래프 일수록 유리
        
        //크루스칼이 구현하기 편해보여서 걍 크루스칼로 먼저 해봅시다
        Arrays.sort(costs, (o1,o2)->o1[2]-o2[2]);
        
        UnionFind uf=new UnionFind(n);
        
        int here=0;
        int answer = 0;
        while(here<costs.length){
            int a=costs[here][0],b=costs[here][1];
            if(uf.find(a)!=uf.find(b)){//같은 집합이면 사이클 발생한거니까 무시
                answer+=costs[here][2];
                uf.union(a,b);
            }
            here++;
        }
        return answer;
    }
}

class UnionFind{
    //코드 좀더 길어지긴 하는데 메모리 2배 안쓰게 할라고 배열 하나만씀 음수면 깊이 저장, 양수면 부모노드
    //https://ssungkang.tistory.com/198
    //유니온 파인드 참고
    public int[] parent;
    UnionFind(int n){
        parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=-1;
    }
    int find(int x){
        if(parent[x]<0)
            return x;
        else{
            int tmp=find(parent[x]);
            parent[x]=tmp; //트리 높이 줄여주는 효과
            return tmp;
        }
    }
    void union(int x, int y){
        x=this.find(x); y=this.find(y); //이렇게 해줘야 부모값 찾고 par 접근!!
        if(x==y)
            return;
        if(parent[x]<parent[y]){
            parent[x]+=parent[y]; //깊이 계산
            parent[y]=x;
        }else{
            parent[y]+=parent[x]; //깊이 계산
            parent[x]=y;
        }
    }
}