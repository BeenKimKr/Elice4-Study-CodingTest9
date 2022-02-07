import java.util.*;

class Solution {
	public static int[] solution(String[] genres, int[] plays) {

		int[] answer = {};

		Map<String, Integer> map = new HashMap<>();

		// Map�� �帣��(key) Ƚ��(value) ���ϱ�
		for(int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}

		// ���������� ���� list
		ArrayList<String> genList = new ArrayList<>(map.keySet()); 
		Collections.sort(genList, (o1, o2) -> map.get(o2) - map.get(o1)); // ��������

		// �뷡�� ������ȣ ����Ʈ
		ArrayList<Integer> numList = new ArrayList<>();

		for(String g : genList) {
			int song1 = 0; // 1���� ������ȣ
			int song2 = 0; // 2���� ������ȣ
			int maxPlay = 0; // ���Ƚ��

			// 1���� ã��
			for(int i = 0; i < genres.length; i++) {
				if(g.equals(genres[i]) && maxPlay < plays[i]) {
					song1 = i;
					maxPlay = plays[i];
				}
			}

			maxPlay = 0;

			// ���Ƚ�� �ʱ�ȭ, 2���� ã��(1���� ����)
			for(int i = 0; i < genres.length; i++) {
				if(g.equals(genres[i]) && maxPlay < plays[i] && song1 != i) {
					song2 = i;
					maxPlay = plays[i];
				}
			}

			numList.add(song1);

			// �帣�� ���� �� ���� ��� ����
			if(maxPlay != 0) numList.add(song2);
		}

		answer = new int[numList.size()];

		for(int i = 0; i < answer.length; i++) {
			answer[i] = numList.get(i);
		}

		return answer;
	}


	public static void main(String args[]) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		int[] result = solution(genres, plays);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}