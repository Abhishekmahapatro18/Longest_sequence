package SelfLearn4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    private final int[] nums;

    public LongestIncreasingSubsequence(int[] nums) {
        this.nums = nums;
    }

    public List<Integer> findLongestIncreasingSubsequence() {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int n = nums.length;
        int[] dp = new int[n];
        int[] indexes = new int[n];
        Arrays.fill(indexes, -1);

        int maxLength = 1;
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    indexes[i] = j;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }

        List<Integer> longestIncreasingSubsequence = new ArrayList<>();
        while (endIndex != -1) {
            longestIncreasingSubsequence.add(nums[endIndex]);
            endIndex = indexes[endIndex];
        }

        return reverseList(longestIncreasingSubsequence);
    }

    private List<Integer> reverseList(List<Integer> list) {
        List<Integer> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(nums);
        List<Integer> longestIncreasingSubsequence = lis.findLongestIncreasingSubsequence();
        System.out.println("Longest Increasing Subsequence: " + longestIncreasingSubsequence);
    }
}
