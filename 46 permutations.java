class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        helper(l, new ArrayList<>(), nums.length - 1, nums);
        return l;
    }

    private void helper(List<List<Integer>> l, List<Integer> mini, int aIndex, int[] nums) {
        if (aIndex == -1) {
            l.add(new ArrayList<>(mini));
        }
        else {
            int digitToAdd = nums[aIndex];
            for (int i = 0; i <= mini.size(); i++) {
                mini.add(i, digitToAdd);
                helper(l, mini, aIndex - 1, nums);
                mini.remove(i);
            }
        }
    }
}