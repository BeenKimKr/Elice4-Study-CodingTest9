import java.util.ArrayList;
import java.util.List;

class PGS43105 {
  static int solution(int[][] triangle) {
    int answer = 0;
    List<String> done = new ArrayList<>();

    if (triangle.length == 1)
      return triangle[0][0];
    else if (triangle.length == 2)
      return Math.max((triangle[0][0] + triangle[1][0]), (triangle[0][0] + triangle[1][1]));

    for (int i = 0; i < triangle.length; i++) {
      int sum = triangle[0][0];
      int p = 0;
      String doneIndex = "";
      // 경로를 저장하여 중복방지하는 방법으로 구현하려 했으나
      // 중간에 경로를 바꾸기 구현 실패...
      for (int j = p; j < p + 1; p++) {
        
        // sum += triangle[i][j];

      }
      done.add(doneIndex);
      answer = Math.max(answer, sum);
    }

    return answer;
  }

  public static void main(String[] args) {
    int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

    System.out.println(solution(triangle));
  }
}
