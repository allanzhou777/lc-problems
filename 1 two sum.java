class Solution {
    public int[] twoSum(int[] nums, int target) {
        // create a hashmap to store all the values
        // for each item in nums, search through hashmap and see if it contains target - nums[i]. if not, add it to the map, and continue
        Map<Integer, Integer> hm = new HashMap<>();
        int[] output = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // if the hashmap contains the difference
            if (hm.containsKey(target - nums[i])) {
                output[0] = hm.get(target-nums[i]);
                output[1] = i;
                return output;
            }
            else {
                hm.put(nums[i], i);
            }
        }
        return output;
    }
}