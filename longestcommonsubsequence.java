import java.util.Arrays;

public class longestcommonsubsequence{

    public static int longestCommonSubsequence(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return lcs(s1, s2, 0, 0, memo);
    }

    private static int lcs(String s1, String s2, int i, int j, int[][] memo) {
        // Base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        // Return cached result
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // Characters match
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + lcs(s1, s2, i + 1, j + 1, memo);
        } else {
            // Skip one character from either string
            memo[i][j] = Math.max(
                lcs(s1, s2, i + 1, j, memo),
                lcs(s1, s2, i, j + 1, memo)
            );
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        System.out.println(longestCommonSubsequence(s1, s2)); // Output: 3
    }
}