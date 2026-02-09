class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else { // ch == ')'
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // valid pair
                } else {
                    stack.push(ch); // unmatched ')'
                }
            }
        }
        return stack.size();
    }
}
