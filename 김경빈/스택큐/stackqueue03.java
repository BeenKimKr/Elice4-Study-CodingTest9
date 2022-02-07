import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        List<int[]> truck = new LinkedList<>(); // �ٸ��� �ǳʴ� Ʈ��, [����, �ð�]
        
        int answer = 0;
        int totalWeight = 0;
        int i = 0;
        
        
        while(true) {
            
            // �ٸ� ���� Ʈ���� ���� �� �ð� 1 ����
            for(int j = 0; j < truck.size();) {
                
                if(--truck.get(j)[1] == 0) {
                    totalWeight -= truck.get(j)[0];
                    truck.remove(j);
                } else {
                    j++;
                }
            }
            
            // ���� Ʈ���� ���� + �ٸ� �� Ʈ���� ���� �� < weight -> �ٸ� ���� �߰�
            if (i < truck_weights.length && truck_weights[i] + totalWeight <= weight) {
				totalWeight += truck_weights[i];
				truck.add(new int[] { truck_weights[i++], bridge_length });
			}
            
            answer += 1;
            
            if(truck.size() == 0) {
                break;
            }
        }
        
        return answer;
    }
}