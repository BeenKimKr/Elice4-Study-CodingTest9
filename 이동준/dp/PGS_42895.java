import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> memo=new ArrayList<>();
    public int dp(int here, int N, int number){
        ArrayList<Integer>tmp=new ArrayList<>();
        //8넘어가면 즉시 종료 -1 리턴
        if(here>8)
            return -1;
        //here 만큼 연달아서 한거 추가 5555같은 수
        int aaa=0;
        for(int i=0;i<here;i++){
            aaa+=(N*Math.pow(10,i));
        }
        tmp.add(aaa);
        if(aaa==number){
            memo.add(tmp);
            return here;
        }
        
        //기존에 계산 된거에다가 +/*- 해서 추가
        //만약에 here 6이면 51 42 33 조합
        //뒤집는거도 해야되나?? 24 15 까지?
        
        for(int i=1;i<here;i++){
        // for(int i=1;i<=here/2;i++){ 
            int x=here-i-1,y=i-1;
            for(int j=0;j<memo.get(x).size();j++){
                for(int k=0;k<memo.get(y).size();k++){
                    int p=memo.get(x).get(j)+memo.get(y).get(k);
                    int mul=memo.get(x).get(j)*memo.get(y).get(k);
                    int minus=memo.get(x).get(j)-memo.get(y).get(k);
                    int d=-1;
                    if(memo.get(y).get(k)!=0)
                        d=memo.get(x).get(j)/memo.get(y).get(k);
                    if(p==number||mul==number||d==number||minus==number)
                        return here;
                    tmp.add(p); tmp.add(mul); tmp.add(minus);
                    if(d!=-1)
                        tmp.add(d);
                }
            }
        }
        memo.add(tmp);
        return dp(here+1,N,number);
    }
    public int solution(int N, int number) {
        int answer = dp(1,N,number);
        return answer;
    }
}