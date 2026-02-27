class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int l = temperatures.length;
        int[] result = new int[l];

        for (int i = 0; i < l; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previndex = stack.pop();
                result[previndex] = i - previndex;
            }
            stack.push(i);
        } 
        return result;
    }
}
