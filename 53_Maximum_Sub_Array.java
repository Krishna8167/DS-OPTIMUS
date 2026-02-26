class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int MaxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            MaxSum = Math.max(MaxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
            //want -ve  answers so didnt check maxSum < 0.
         }
          return MaxSum;
    }
}
