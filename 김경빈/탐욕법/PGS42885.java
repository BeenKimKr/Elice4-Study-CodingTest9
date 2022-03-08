import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PGS42885 {
  public static int solution(int[] people, int limit) {
    int answer = 0;
    List<Integer> pList = new ArrayList<>();

    Arrays.sort(people);
    if (people[0] + people[1] > limit)
      return people.length;

    for (int i : people) {
      if (i + people[0] <= limit) {
        pList.add(i);
      } else {
        answer += 1; // 혼자 타는 사람
      }
    }

    while (!pList.isEmpty()) {
      int minOne = pList.get(0);
      int minTwo = 0;
      pList.remove(pList.indexOf(minOne));

      if (pList.isEmpty())
        return answer + 1;

      // minTwo 찾기
      if (pList.contains(limit - minOne)) {
        minTwo = limit - minOne;
      } else {
        for (int k : pList) {
          if (k <= (limit - minOne) && k >= minTwo) {
            minTwo = Math.max(minTwo, k);
          }
        }
      }
      // 전부 짝x
      if (minTwo == 0)
        return answer + pList.size() + 1;

      pList.remove(pList.indexOf(minTwo));
      answer += 1;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[][] people = { { 70, 50, 80, 50 }, { 70, 80, 50 } };
    int[] limit = { 100, 100 };

    System.out.println(solution(people[0], limit[0]));
    System.out.println(solution(people[1], limit[1]));
  }
}
