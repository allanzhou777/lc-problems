class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int repeats = 0; 
        int i = 0; 
        int j = 1; 
        int max = 0;
        int n = nums.length;
        
        if (n == 0 || n == 1) {
            return n;
        }

        while (j < n) {
            if (j - i - repeats + 1 > max) {
                max = j - i - repeats;
            }
            if (nums[j] - nums[j - 1] == 1) {
                // i stays where it is
                // j increment
                j += 1;
            }
            else if (nums[j] == nums[j - 1]) {
                j += 1;
                repeats += 1;
            }
            else {
                i = j;
                j += 1;
                repeats = 0;
            }
        if (j - i - repeats + 1 > max) {
                max = j - i - repeats;
            }    
        }
        return max;
    }
}
/*
 *
 *
 * class Solution {
    public int longestConsecutive(int[] nums) {
        // first create the hashset
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        Set<Integer> hs = new HashSet<>();
        for (int item : nums) {
            hs.add(item);
        }

        // now iterate through the list in order
        // if set.contains(nums[i] - 1), then skip this number
        // because we know the current number must be used at a certain point
        // but if !set.contains(nums[i] - 1), then
        // go thru a while loop and find how many consecutive items there are
        int counter = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (hs.contains(nums[i] - 1)) {
                continue;
            }
            else {
                int temp = 1;
                while (hs.contains(nums[i] + temp)) {
                    temp += 1;
                }
                counter = Math.max(counter, temp);
            }
            
        }
        return counter;
    }
}
 */
