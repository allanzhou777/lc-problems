class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums.length / 2;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            if (hm.get(num) > maj) {
                return num;
            }
        }
        return -1;
        
    }
}