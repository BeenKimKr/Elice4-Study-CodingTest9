/*
문제 푸는 방법 생각하는데 10분 걸리고 처음 구현하는데 5분걸려서 15분만에 푼줄 알았는데
개같은 자바... 시간초과랑 런타임 에러 뜸

한 30분 더 붙잡고 보다가 런타임 에러 뜨는 이유 발견하고 이거 해결

대충 문제 푸는 로직짜고 엣지케이스 잡는데는 40분쯤 걸렸는데 시간초과 뜨는거 해결할라고 별의별 지랄을 3시간동안하고 깨달은 것

자바의 기본 String 클래스는 불변클래스임
문자열 수정이 매우 불편함. 보안상의 이유나 캐싱 스래드 동기화 등등에서 이점을 갖기 때문에 기본 String은 immutable임..
https://www.baeldung.com/java-string-immutable
https://dololak.tistory.com/699

String 수정 방법 찾을때 substring이랑 +연산자 쓰길래 뭐이리 복잡하지하고 뭔가 아차 싶었는데 그냥 귀찮아서 더 안찾아봄..

하지만 이렇게 하면 많은 중간 문자열 객체가 쥰내게 생성되어 쥰내게 오래걸림
스트링을 수정하기 편리한 클래스 또 존재함 스트링빌더와 스트링버퍼라는
https://onlyfor-me-blog.tistory.com/317

$$아무튼 이 문제 풀면서 깨달은점 요약$$

자바에서 문자열 수정할때는 스트링빌더를 쓰자..
*/

class Solution {
    public String solution(String number, int k) {
        int here=0,pop=0;
        StringBuilder answer=new StringBuilder(number);
        while(pop<k){
            if(here==answer.length()-1)
                break;
            if(answer.charAt(here)<answer.charAt(here+1)){
                answer.deleteCharAt(here);
                pop++;
                if(here!=0){
                    if(answer.charAt(here-1)<answer.charAt(here))
                        here--;
                }
            }else{
                here++;
            }
        }
        for(int i=0;i<k-pop;i++){ //내림차순으로 정렬된 경우 뒤에꺼부터 뺌.. 이거 안하면 런타임에러남
            answer.deleteCharAt(answer.length()-1);
        }
        return answer.toString();
        //지금 보고있는 숫자가 바로 뒷숫자 보다 작으면 뺌
        //지금 보고있는게 바로 뒷숫자보다 크면 지금 보고있는 숫자 한칸 밀기
    }
}

/*
뻘짓의 흔적들..

맨처음 그냥 String클래스만 쓴 코드
섭스트링 많이해서 시간이 오래걸렸음.. 계속 메모리 할당했다 풀었다 하니까

class Solution {
    public String solution(String number, int k) {
        int here=0,pop=0;
        String answer = number;
        while(pop<k){
            if(here==answer.length()-1)
                break;
            if(answer.charAt(here)<answer.charAt(here+1)){
                answer=answer.substring(0,here)+answer.substring(here+1); 
                pop++;
                if(here!=0){
                    if(answer.charAt(here-1)<answer.charAt(here))
                        here--;
                }
            }else{
                here++;
            }
        }
        for(int i=0;i<k-pop;i++){ //내림차순으로 정렬된 경우 뒤에꺼부터 뺌
            answer=answer.substring(0,answer.length()-1);
        }
        return answer;
        //지금 보고있는 숫자가 바로 뒷숫자 보다 작으면 뺌
        //지금 보고있는게 바로 뒷숫자보다 크면 지금 보고있는 숫자 한칸 밀기
    }
}

두번째 뻘짓..
왤케 오래걸리나 싶어서 찾아보다가 자료구조 탓인듯 해서 링크드 리스트로 변경...
근데 시간은 비슷하게 걸림. 심지어 시간초과 그대로뜸
get을 좀 찾아봤는데 이게 맨앞에서 부터 찾는다고 되있어서
그럼 아예 이터레이터를 써보자라는 생각이 남

import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int pop=0, here=0;
        LinkedList<Character>a=new LinkedList<>();
        for(int i=0;i<number.length();i++){
            a.addLast(number.charAt(i));
        }
        
        String answer = "";
        while(pop<k){
            if(here==a.size()-1)
                break;
            if(a.get(here)<a.get(here+1)){
                a.remove(here);
                pop++;
                if(here!=0){
                    if(a.get(here-1)<a.get(here))
                        here--;
                }
            }else{
                here++;
            }
        }
        for(int i=0;i<k-pop;i++){ //내림차순으로 정렬된 경우 뒤에꺼부터 뺌
            a.removeLast();
        }
        for(int i=0;i<a.size();i++){
            answer+=a.get(i);
        }
        return answer;
        //지금 보고있는 숫자가 바로 뒷숫자 보다 작으면 뺌
        //지금 보고있는게 바로 뒷숫자보다 크면 지금 보고있는 숫자 한칸 밀기
    }
}

이터레이터 뻘짓..
시간초과는 안뜨고 실행은 완료되긴해서 아좀 빨라졌네 싶음
코드 보면 알겠지만 이거 엄청 가독성도 구리고 중간에 디버깅하다가 컴퓨터 부술뻔함
근데 심지어 제출하니까 1,11,12만 되고 나머지 다 오답뜸...
어디서 틀린지 모르겠어서 걍 포기하고 좀더 구글링하다가
스트링 수정에는 스트링빌더 쓰면 좋다는 글 봄

class Solution {
    public String solution(String number, int k) {
        int pop=0;
        LinkedList<Character>a=new LinkedList<>();
        for(int i=0;i<number.length();i++){
            a.addLast(number.charAt(i));
        }
        ListIterator<Character>iter=a.listIterator();
        
        String answer = "";
        while(pop<k&&iter.hasNext()){
            char here=iter.next();
            if(!iter.hasNext())
                break;
            char hereNext=iter.next();
            iter.previous();
            if(here<hereNext){
                iter.previous();
                iter.remove();
                pop++;
                if(iter.hasPrevious()){
                    char herePrev=iter.previous();
                    iter.next();
                    char heretmp=iter.next();
                    if(herePrev<heretmp){
                        iter.previous(); iter.previous();
                    }
                }
            }else{
                //iter.next();
            }
        }
        for(int i=0;i<k-pop;i++){ //내림차순으로 정렬된 경우 뒤에꺼부터 뺌
            a.removeLast();
        }
        iter=a.listIterator();
        while(iter.hasNext()){
            answer+=iter.next();
        }
        return answer;
        //지금 보고있는 숫자가 바로 뒷숫자 보다 작으면 뺌
        //지금 보고있는게 바로 뒷숫자보다 크면 지금 보고있는 숫자 한칸 밀기
    }
}

*/