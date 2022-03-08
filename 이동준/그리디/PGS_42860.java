import java.util.*;

class Now{
    public int depth,here;
    public ArrayList<Integer> status;
    public boolean check(){
        for(int i=0;i<this.status.size();i++){
            if(this.status.get(i)!=0)
                return false;
        }
        return true;
    }
    Now(int d,int h,ArrayList<Integer> s){
        this.depth=d; this.status=s; this.here=h;
    }
}
class Solution {
    public int solution(String name) {
        int answer = 0;
        ArrayList<Integer> alp=new ArrayList();
        for(int i=0;i<name.length();i++){ //처음 이부분은 금방 생각했는데 이걸 좀더 확장시켜서 생각해보면 좌우로 움직이는것에도 적용할수 있다는거..
            alp.add(Math.min(name.charAt(i)-'A',26-(name.charAt(i)-'A'))); //앞으로 가는게 빠른지 뒤로가는게 빠른지 골라
            answer+=alp.get(i);
        }
        //01001000010
        //01000000010
        //00000100
        //bfs??시간복잡도 높은건 알겠는데 일단 구현해봄.. 그냥 모든 경우 다 해보는 멍청한 방법임미다..
        //지금 코드에서 방문 노드 조금더 줄일수 있는 방법있긴함 한번 방향 꺾은 경우 더이상 lr 모두 추가 안해도 됨 한방향으로 계쏙 ㄱ.. ㄹㅇ 조금 줄어들긴함
        //제일 오래걸린게 원래 30ms 걸리던거 9ms로 줄긴함.. 그래도 오래걸림 그리디는 평균 0.03ms 정도 걸림
        //그리디로 하면 O(n)타임 bfs로 하면 O(노드 갯수)이니까 O(2^n)타임인가?? 암튼 겁나 오래걸림
        //https://velog.io/@jeeseob5761/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1
        //제일 깔끔한 그리디 풀이 이해하기 편함.. 연속된 a를 안지나야한다는거까진 생각했는데 그리디로 구현하는게 생각이 안남..
        //해당 위치마다 그리디하게 판별 한다!!
        Queue<Now> q=new LinkedList<>();
        alp.set(0,0);
        Now tmp=new Now(answer,0,alp);
        q.add(tmp);
        while(!q.isEmpty()){
            tmp=q.poll();
            if(tmp.check()){
                answer=tmp.depth;
                break;
            }
            ArrayList<Integer> ll=new ArrayList<>(); //처음에 얕은 복사(주소 복사)로 써서 고침
            for(int i:tmp.status){  //자바는 깊은 복사(값만 복사)가 안되서 직접 깊은복사
                ll.add(i);
            }
            int tmpl=(name.length()+tmp.here-1)%name.length();
            ll.set(tmpl,0);
            Now l=new Now(tmp.depth+1,tmpl,ll);

            ArrayList<Integer> rr=new ArrayList<>();
            for(int i:tmp.status){
                rr.add(i);
            }
            int tmpr=(tmp.here+1)%name.length();
            rr.set(tmpr,0);
            Now r=new Now(tmp.depth+1,tmpr,rr);

            //앞 뒤 추가
            q.add(l);
            q.add(r);
        }
        return answer;
    }
}