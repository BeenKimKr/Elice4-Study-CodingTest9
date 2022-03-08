import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        ArrayList<String> reserveList = new ArrayList<>();
        ArrayList<Integer> lostList = new ArrayList<>();
        //배열 수정이 편한 ArrayList 사용
        for(int i: reserve) {
            reserveList.add(Integer.toString(i));
        }
        
        int count = 0;
        //도난당했으나 여벌의 옷이 있는 경우 제외
        for(int i: lost) {
            if(reserveList.contains(Integer.toString(i))) {
                count++;
                reserveList.remove(Integer.toString(i));
                
            } else {
                lostList.add(i);    
            }
        }
        //오름차순 정렬 반드시 해야함.
        lostList.sort(Comparator.naturalOrder());
        reserveList.sort(Comparator.naturalOrder());
        
        //이제 하나씩 비교
        for(int i: lostList) {
            String upperCase = Integer.toString(i+1);
            String lowerCase = Integer.toString(i-1);
            
            if(reserveList.contains(lowerCase)) {
                count++;
                reserveList.remove(lowerCase);
            } else if(reserveList.contains(upperCase)) {
                count++;
                reserveList.remove(upperCase);
            }
        }
        return answer+count;
    }
}