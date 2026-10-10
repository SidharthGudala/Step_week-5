import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matches) {
        return matches >= 10;
    }

    static boolean isDraftable(int matches, boolean injured) {
        return matches >= 5 && !injured;
    }

    public int compareTo(Player p) {
        return Double.compare(p.battingAverage, battingAverage);
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int n = 0;

        for (Player p : players)
            if (isDraftable(p.matchesPlayed) ||
                isDraftable(p.matchesPlayed, p.injured))
                draftable[n++] = p;

        draftable = Arrays.copyOf(draftable, n);
        Arrays.sort(draftable);

        String result = "";
        for (int i = 0; i < n; i++) {
            if (i > 0) result += " | ";
            result += (i + 1) + ". " + draftable[i].name;
        }

        return result;
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
