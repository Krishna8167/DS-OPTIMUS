import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixsum = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : nums) {
            prefixsum += num;

            if (map.containsKey(prefixsum - k)) {
                count += map.get(prefixsum - k);
            }

            if (map.containsKey(prefixsum)) {
                map.put(prefixsum, map.get(prefixsum) + 1);
            } else {
                map.put(prefixsum, 1);
            }
        }

        return count;
    }
}
