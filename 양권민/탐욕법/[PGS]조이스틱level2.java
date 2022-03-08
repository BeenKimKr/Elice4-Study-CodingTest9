import java.util.*;
//미해결

class Solution {
    public int solution(String name) {
        int answer = 0;
        ArrayList<Integer> countList = new ArrayList<>();
        int codeA = 65;
        int codeZ = 90;
        
        for(int i=0; i<name.length(); i++) {
            int up = (int)name.charAt(i)-codeA;
            int down = (codeZ+1)-(int)name.charAt(i);
            countList.add(Math.min(up, down));
            answer += Math.min(up, down);
        }
        
        int rightZero = 0;
        int leftZero= 0;
        
        Stack<Integer> rightWay = new Stack<>();
        Stack<Integer> leftWay = new Stack<>();
        
        for(int i=1; i< countList.size();i++) {
            leftWay.push(countList.get(i));
        }
        for(int i= countList.size()-1; i>0; i--) {
            rightWay.push(countList.get(i));
        }
        
        while(true) {
            if(leftWay.pop()==0) leftZero++;
            else break;
        }
        while(true) {
            if(rightWay.pop()==0) rightZero++;
            else break;
        }
        
        if(leftZero > rightZero) {
            answer += name.length()-1-leftZero;
        } else if(leftZero < rightZero) {
            answer += name.length()-1-rightZero;
        } else {
            answer += (name.length()-1);
        }
        
        return answer;
    }
}