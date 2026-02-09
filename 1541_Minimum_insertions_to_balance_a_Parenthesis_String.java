class Solution {
    public int minInsertions(String s) {
        int need = 0;   // how many ')' we need
        int count = 0;  // how many insertions we do

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // '(' needs two ')'
                if (need % 2 == 1) {
                    // fix odd ')' requirement
                    count++;
                    need--;
                }
                need += 2;
            } else { // ch == ')'
                need--;
                if (need < 0) {
                    // missing '('
                    count++;
                    need = 1;
                }
            }
        }

        return count + need;
    }
}
