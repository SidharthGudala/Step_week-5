class HackathonSeatingGridOptimizer {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int x : row) sum += x;
        return row.length == 0 ? 0 : (double) sum / row.length;
    }

    static String classifyRows(int[][] scores, int threshold) {
        String result = "";

        for (int i = 0; i < scores.length; i++) {
            if (i > 0) result += " | ";
            result += "Row " + i + ": " +
                (rowAverage(scores[i]) < threshold ? "Quiet Zone" : "Buzzing Zone");
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] scores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        System.out.println(classifyRows(scores, 60));
    }
}
