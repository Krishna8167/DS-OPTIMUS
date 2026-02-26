case 1 : Brute force not the optimal solution.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // will not happen per problem statement
    }
}

case 2: HashMap for the optimal solution.

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        } 
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (maps.containsKey(need)) {
                return new int[] {i, maps.get(need) };
                }

                maps.put(nums[i], i);
            }

        return new int[]{-1, -1};
    }
}

