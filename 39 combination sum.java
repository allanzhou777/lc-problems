class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(candidates);
        helper(l, new ArrayList<>(), candidates, target, 0);
        return l;

    }

    public void helper(List<List<Integer>> l, List<Integer> mini, int[] c, int target, int index) {
        // if target == 0, add the temp to l
        if (target == 0) {
            l.add(new ArrayList<>(mini));
            return;
        }

        // for i in range of everything, since you can include duplicates
        for (int i = index; i < c.length; i++) {
            if (target - c[i] < 0) {
                break;
            }
            mini.add(c[i]);
            helper(l, mini, c, target - c[i], i);
            mini.remove(mini.size() - 1);
        }
            // if adding the next number isn't valid
                // break
            // add the next number
            // helper()
    }


}