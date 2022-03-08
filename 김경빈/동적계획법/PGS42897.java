public class PGS42897 {
  public static int solution(int[] money) {
    int answer = 0;
    int length = money.length;

    if (length < 4) {
      for (int i = 0; i < length; i++) {
        answer = Math.max(money[i], answer);
      }
      return answer;
    }

    int[] cacheA = new int[length];
    int[] cacheB = new int[length];

    cacheA[0] = money[0];
    cacheA[1] = money[1];
    cacheA[2] = cacheA[0] + money[2];

    for (int i = 3; i < length - 1; i++) {
      cacheA[i] = Math.max(cacheA[i - 3] + money[i], cacheA[i - 2] + money[i]);
    }
    answer = Math.max(cacheA[length - 2], cacheA[length - 3]);

    cacheB[1] = money[1];
    cacheB[2] = money[2];
    cacheB[3] = cacheB[1] + money[3];

    for (int i = 4; i < length; i++) {
      cacheB[i] = Math.max(cacheB[i - 3] + money[i], cacheB[i - 2] + money[i]);
    }

    answer = Math.max(cacheB[length - 1], answer);

    return answer;
  }

  public static void main(String[] args) {
    int[] money = { 1, 2, 3, 1 };

    System.out.println(solution(money));
  }
}
