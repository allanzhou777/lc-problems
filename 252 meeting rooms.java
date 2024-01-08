class Solution {
    public boolean meeting(int[] intervals) {
        int n = intervals.length;
        int[] arr = new int[2];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                arr = intervals[j];
                if (!(arr[0] <= intervals[i][0] && intervals[i][0] <= arr[1]) || !(arr[0] <= intervals[i][0] && intervals[i][0] <= arr[1])) {
                    return false;
                }
            }
        }
        return true;
    }
}