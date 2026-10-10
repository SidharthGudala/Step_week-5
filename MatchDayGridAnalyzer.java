class MatchDayGridAnalyzer {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int x : row) sum += x;
        return row.length == 0 ? 0 : (double) sum / row.length;
    }

    static String classifyMatches(int[][] runs, int threshold) {
        String result = "";

        for (int i = 0; i < runs.length; i++) {
            if (i > 0) result += " | ";
            result += "Match " + i + ": " +
                (rowAverage(runs[i]) >= threshold ? "Power Surge" : "Normal");
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] runs = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        System.out.println(classifyMatches(runs, 8));
    }
}
