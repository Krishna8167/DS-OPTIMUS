class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int MaxArea = Integer.MIN_VALUE;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            MaxArea = Math.max(MaxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return MaxArea;
    }
}
