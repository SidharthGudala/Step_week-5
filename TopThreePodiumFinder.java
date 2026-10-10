import java.util.Arrays;

class TopThreePodiumFinder {
    static int[] findTopThreeScores(int[] scores) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;

        for (int x : scores) {
            if (x >= a) {
                c = b;
                b = a;
                a = x;
            } else if (x >= b) {
                c = b;
                b = x;
            } else if (x > c) {
                c = x;
            }
        }

        return new int[]{a, b, c};
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(scores)));
    }
}
