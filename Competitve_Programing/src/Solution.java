import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Solution {
    static Scanner scanner = new java.util.Scanner(System.in);
    public int sumCounts(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int j = i; j < n; j++) {
                mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
                int distinct = mp.size();
                sum += distinct * distinct;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = solution.sumCounts(nums);
        System.out.println("Result: " + result);
    }
    /*
    Sample inputs :
    3
    1 2 1
     */
}
