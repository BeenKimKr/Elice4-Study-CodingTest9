import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class PGS42862 {

  public static int solution(int n, int[] lost, int[] reserve) {
    List<Integer> lostList = new ArrayList<>();
    List<Integer> reserveList = new ArrayList<>();

    lostList = listSort(listInsert(lost));
    reserveList = listSort(listInsert(reserve));

    // for(int i : lostList) -> lostList에서 remove시 index가 밀려 반복을 안돎
    Iterator<Integer> iter1 = lostList.iterator();

    while (iter1.hasNext()) {
      int student = iter1.next();
      if (reserveList.contains(student)) {
        iter1.remove();
        reserveList.remove(reserveList.indexOf(student)); // 여벌의 체육복 중 하나를 잃어버린..
      }
    }

    Iterator<Integer> iter2 = lostList.iterator();

    while (iter2.hasNext()) {
      int student = iter2.next(); // 잃어버린 학생 번호

      if (reserveList.contains(student - 1)) {
        iter2.remove();
        reserveList.remove(reserveList.indexOf(student - 1));
      } else if (reserveList.contains(student + 1)) {
        iter2.remove();
        reserveList.remove(reserveList.indexOf(student + 1));
      }
    }
    // System.out.println("..." + lostList.toString() + "\n..." + reserveList.toString());
    int answer = n - lostList.size();

    return answer;
  }

  // ArrayList 정렬
  public static List<Integer> listSort(List<Integer> list) {
    list.sort(new Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });

    return list;
  }

  // 배열 삽입
  public static List<Integer> listInsert(int[] arr) {
    List<Integer> result = new ArrayList<>();

    for (int i : arr) {
      result.add(i);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] n = { 5, 5, 3, 5, 5 };
    int[][] lost = { { 2, 4 }, { 2, 4 }, { 3 }, { 2, 4 }, { 2, 3 } };
    int[][] reserve = { { 1, 3, 5 }, { 3 }, { 1 }, { 2, 4 }, { 3, 4 } };

    for (int i = 0; i < n.length; i++) {
      System.out.println(solution(n[i], lost[i], reserve[i]));
    }
  }
}
