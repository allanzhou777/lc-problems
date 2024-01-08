class Solution {
    public int trap(int[] height) {
        // DP maximum index to left of a point
        // DP maximum index to right of a point. 
        // for each point, take min(l[i], r[i]) - height[i], and sum up
        int n = height.length;
        int[] r = new int[n];
        int[] l = new int[n];
        r[n - 1] = 0;
        l[0] = 0;
        int sum = 0;
        int maxToRight = height[n -1]; 
        int maxToLeft = height[0];
        for (int i = 1; i < n; i++) {
            l[i] = Math.max(height[i], maxToLeft);
            maxToLeft = l[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = Math.max(height[i], maxToRight);
            maxToRight = r[i];
        }
        System.out.println(Arrays.toString(r));
        System.out.println(Arrays.toString(l));
        for (int i = 1; i < n - 1; i++) {
            int addition = Math.min(r[i], l[i]) - height[i];
            if (addition > 0) {
                sum += addition;
            }
        }
        return sum;
    }

}