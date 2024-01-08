class Solution {
    public int rob(int[] nums) {
        // starting at house 0, you can rob
        // 0, 2 - diff 2
        // 1, 3 - diff 2
        // 0, 3, diff 3
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int[] arr = new int[nums.length + 1];
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        arr[2] = Math.max(nums[0] + nums[2], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            arr[i] = Math.max(Math.max(nums[i] + arr[i - 2], arr[i - 1]), nums[i] + arr[i - 3]);
        }
        return arr[nums.length - 1];
    }
}