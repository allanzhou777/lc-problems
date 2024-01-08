class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> mini = new ArrayList<>();
        helper(nums, 0, l, mini);
        return l;
    }

    private void helper(int[] nums, int index, List<List<Integer>> l, List<Integer> mini) {
        if (index == nums.length) {
            l.add(new ArrayList<>(mini));
        }
        else {
            helper(nums, index + 1, l, mini);
            mini.add(nums[index]);
            helper(nums, index + 1, l, mini);
            mini.remove(mini.size() - 1);
        }
        
    }
}