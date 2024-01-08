class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() ==0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE,startIndex =0;
        for (char c :t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- >0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE? new String():
                new String(chS,startIndex,minLen);




    //     // hashmap with sliding window
    //     // get the hashmap of the substr string
    //     if (s.length() < ss.length()) {
    //         return "";
    //     }
    //     int[] smap = new int[256];
    //     int[] ssmap = new int[256];
    //     for (int i = 0; i < ss.length(); i++) {
    //         ssmap[ss.charAt(i)] += 1;
    //         smap[s.charAt(i)] += 1;
    //     }
    //     int l = 0; 
    //     int r = ss.length(); 
    //     int minWindowLength = Integer.MAX_VALUE;
    //     String minWindow = "";
    //     while (r < s.length() && l <= r) {
    //         if (validWindow(smap, ssmap) && r - l + 1 < minWindowLength) {
    //             minWindowLength = r - l + 1;
    //             minWindow = s.substring(l, r + 1);
    //         }
    //         if (validWindow(smap, ssmap)) {
    //             while (ssmap[s.charAt(l)] == 0) {
    //                 smap[s.charAt(l)] -= 1;
    //                 l += 1;
    //             }
    //         }
    //         else {
    //             smap[s.charAt(r)] += 1;
    //             r += 1;
    //         }
    //     }
    //     return minWindow;
    // }


    // private boolean validWindow(int[] smap, int[] ssmap) {
    //     for (int i = 0; i < ssmap.length; i++) {
    //         if (smap[i] < ssmap[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // private boolean charIncluded(char c, String substr) {
    //     for (int i = 0; i < substr.length(); i++) {
    //         if (c == substr.charAt(i)) {
    //             return true;
    //         }
    //     }
    //     return false;
    }
}