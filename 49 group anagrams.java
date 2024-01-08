class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        // search through each item in strs and see if the sorted 'key' exists. if it does, add the value to the sorted key. if not, add both

        for (int i = 0; i < strs.length; i++) {
            char[] unsorted = strs[i].toCharArray();
            Arrays.sort(unsorted);
            String sorted = new String(unsorted);
            if (!hm.containsKey(sorted)) {
                hm.put(sorted, new ArrayList<>());
            }
            hm.get(sorted).add(strs[i]);
            
        }

        return new ArrayList<>(hm.values());




























        // Map<String, List<String>> map = new HashMap<>();
        
        // for (int i = 0; i < strs.length; i ++) {
        //     char[] chars = strs[i].toCharArray();
        //     Arrays.sort(chars);
        //     String orderedItem = new String(chars);


        //     if (!map.containsKey(orderedItem)) {
        //         map.put(orderedItem, new ArrayList<>());
        //     }
            
        //     map.get(orderedItem).add(strs[i]);

        // }
        // return new ArrayList<>(map.values());

    }
}