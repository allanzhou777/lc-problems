class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        // find the max number of bananas in a pile 
        for (int i = 1; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        // for every value from 1 to max, do binary testing on each value such that the hours taken (Math.ceiling(smth))is equal to h
        int l = 1; 
        int r = max;
        while (l < r) {
            int speed = (l+r) / 2;
            int hours = 0; 
            // get the total number of hours if would take, adding the hours for each item
            for (int j = 0; j < piles.length; j++) {
                hours += (piles[j] -1) / speed + 1;
            }
            if (hours > h) {
                l = speed + 1;
            }
            else if (hours <= h) {
                r = speed;
            }

        }
        return l;
    }
}