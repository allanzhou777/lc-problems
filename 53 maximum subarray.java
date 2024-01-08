class Solution {
    public int maxSubArray(int[] nums) {
        int[] prefixSums = new int[nums.length+1];
        prefixSums[0] = 0;
        for (int i = 1; i < nums.length + 1; i ++) {
            prefixSums[i] = prefixSums[i-1] + nums[i-1];
        }

        // defines the scope of min, currently only covers index 0
        int min = prefixSums[0];

        // global max
        int max = Integer.MIN_VALUE;

        //
        for (int i = 1; i < prefixSums.length; i++) {

            // finds the max for the current index i
            //compares it to global max
            max = Math.max(max, prefixSums[i]-min);

            // increases scope of minimum to cover current index
            min = Math.min(min, prefixSums[i]);

        }
        return max;
    }
}
