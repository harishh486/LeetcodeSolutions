class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map <String, List> map = new HashMap<String, List>();
        
        if(strs.length == 0)
            return new ArrayList<>();
        for (String s: strs){
            //conver the string to charArray
            char [] ch = s.toCharArray();
            //sort
            Arrays.sort(ch);
            //convert back to string and make it as key
            String key = String.valueOf(ch);
            
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            
            map.get(key).add(s);
            //get that key value And add string to it
                
                
                
        }
        //return a list of lists
        //from map values
        return new ArrayList(map.values());
        
        
    }
}

// defuine map string list
//iterate each str over array
//for each string
//conbvert to charArray and then sort and then convert back to string which acts a s a key
//now in map if key present  add the current string ur iterating else create a key with empty list and then add current string 
// once we fill all values we group all anagrams in list og map vaules map.values give s all values
//new Arraylist(map.values())--return list of lists


//T: 0(nklogk)
//S:0(nk)
//n -lenth og string arrays and to sort each st we take klogk

//for each str--> convert to array, sort it and convrt bck to string to make it as key in map<string, list>
//we can use without arrays to make it T:0(nk)

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs.length == 0) return new ArrayList();
//         Map<String, List> ans = new HashMap<String, List>();
//         int[] count = new int[26];
//         for (String s : strs) {
//             Arrays.fill(count, 0);
//             for (char c : s.toCharArray()) count[c - 'a']++;

//             StringBuilder sb = new StringBuilder("");
//             for (int i = 0; i < 26; i++) {
//                 sb.append('#');
//                 sb.append(count[i]);
//             }
//             String key = sb.toString();
//             if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//             ans.get(key).add(s);
//         }
//         return new ArrayList(ans.values());
//     }
// }

// Time Complexity: O(NK)O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.

// Space Complexity: O(NK)O(NK), the total information content stored in ans.