class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        helper(l, new ArrayList<>(), 0, nums);
        return l;
    }

    private void helper(List<List<Integer>> l, List<Integer> mini, int index, int[] nums) {
        if (index == nums.length) {
            boolean add = true;
            for (List<Integer> miniList : l) {
                if (miniList.equals(mini)) {
                    add = false;
                    break;
                }
            }
            if (add) {
                l.add(new ArrayList<>(mini));
            }
        }
        else {
            helper(l, mini, index + 1, nums);
            mini.add(nums[index]);
            helper(l, mini, index + 1, nums);
            mini.remove(mini.size() - 1);
        }
    }

    
}