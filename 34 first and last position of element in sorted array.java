class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i = 0; 
        int j = n - 1;
        int[] arr = new int[2];
        if (n == 0) {
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }

        while (j - i > 1) {
            int m = i + (j - i) / 2;
            if (target > nums[m]) {
                i = m;
            }
            else if (target <= nums[m]) {
                j = m;
            }
        }

        int start = j;
        if (nums[j] != target) {
            start = -1;
        }
        if (nums[i] == target) {
            start = i;
        }

        i = 0;
        j = n - 1;

        while (j - i > 1) {
            int m = i + (j - i) / 2;
            if (target >= nums[m]) {
                i = m;
            }
            else if (target < nums[m]) {
                j = m;
            }
        }

        int end = i;
        if (nums[end] != target) {
            end = -1;
        }
        if (nums[j] == target) {
            end = j;
        }
        arr[0] = start;
        arr[1] = end;
        return arr;
    }
}