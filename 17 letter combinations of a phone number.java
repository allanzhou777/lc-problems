class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[10];
        letters[2] = "abc";
        letters[3] = "def";
        letters[4] = "ghi";
        letters[5] = "jkl";
        letters[6] = "mno";
        letters[7] = "pqrs";
        letters[8] = "tuv";
        letters[9] = "wxyz";

        List<String> l = new ArrayList<>();
        if (digits.length() == 0) {
            return l;
        }
        helper (digits, l, 0, letters, new String());
        return l;
    }

    private void helper(String digits, List<String> l, int index, String[] letters, String mini) {
        if (index == digits.length()) {
            l.add(new String(mini));
        }
        else {
            int n = digits.charAt(index) - '0';
            for (int i = 0; i < letters[n].length(); i++) {
                mini = mini + letters[n].charAt(i);
                helper(digits, l, index + 1, letters, mini);
                mini = mini.substring(0, mini.length() - 1);
            }
        }
        
    }
}