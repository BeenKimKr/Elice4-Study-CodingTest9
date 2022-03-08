import java.util.*;
//미해결
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int idx = 1;
        while(true) {
            if(k == 0) break;
            int num1 = Integer.parseInt(number.substring(idx-1,idx));
            int num2 = Integer.parseInt(number.substring(idx,idx+1));
            if(num1 == num2 ) {
                idx++;
                continue;
            }
            int minNum = Math.min(num1,num2);
            String delNum = Integer.toString(minNum);
            int delidx = number.indexOf(delNum);
            number = number.substring(0,delidx) + number.substring(delidx+1);
            k--;
        };
        answer = number;
        return answer;
    }
}