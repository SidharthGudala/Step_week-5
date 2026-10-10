import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double compositeScore() {
        return cgpa * 10 + codingScore;
    }

    public int compareTo(Candidate c) {
        return Double.compare(c.compositeScore(), compositeScore());
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] selected = new Candidate[candidates.length];
        int n = 0;

        for (Candidate c : candidates)
            if (isEligible(c.cgpa) ||
                isEligible(c.cgpa, c.codingScore))
                selected[n++] = c;

        selected = Arrays.copyOf(selected, n);
        Arrays.sort(selected);

        String result = "";
        for (int i = 0; i < n; i++) {
            if (i > 0) result += " | ";
            result += (i + 1) + ". " + selected[i].name +
                      " (" + selected[i].compositeScore() + ")";
        }

        return result;
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
