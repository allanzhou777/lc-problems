class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (s.isEmpty()) {
                s.push(c);
            }
            else {
                if (match(s.peek(), c)) {
                    s.pop();
                }
                else {
                    s.push(c);
                }
            }
        }
        return (s.size() == 0);
    }

    private boolean match(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        if (c1 == '{' && c2 == '}') {
            return true;
        }
        
        return false;
    }
}