class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        create a hashmap <value, freq>
        check for -(a + b) in hashmap
        check conditions, making sure no 
        */
        Set<List<Integer>> l = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // nums[i] is smallest, has to be negative
            if (nums[i] > 0) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int s = nums[i] + nums[j] + nums[k];
                if (s == 0) {
                    l.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (s > 0) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return new ArrayList<>(l);
    }
}
