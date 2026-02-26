class Solution {
    public int[] productExceptSelf(int[] nums) {
     int[] arr = new int[nums.length];
     arr[0] = 1;
     int rightprod = 1;
     //left

     for (int i = 1; i < nums.length;i++) {
        arr[i] = arr[i-1] * nums[i-1];
     } 

    //right
    for (int i = nums.length - 1; i >= 0; i--) {
        arr[i] = arr[i] * rightprod;
        rightprod *= nums[i];
    }
     return arr; 
    }
}
