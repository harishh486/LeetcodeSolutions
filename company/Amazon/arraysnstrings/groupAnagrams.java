class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        //initialize
        Map <String ,List> map = new HashMap();
        
        if( strs.length == 0)
            return new ArrayList();
        for(String s: strs){
            char[] ch = s.toCharArray();
            //since it is a array and we can use arrays.sort
            Arrays.sort(ch);
            //convert the char Array to string
            String key = String.valueOf(ch);
            
            //if the str does not have in map already yet , we insert ordered key and empty list
            if(!map.containsKey(key))
                map.put(key, new ArrayList());
            //if it contains then it comes here
            // then we ll get that key and add current string we are iterting to the emptylist or already filled list
            map.get(key).add(s);// thats how we add all similar values
                
            
        }
   
        
        return new ArrayList(map.values());
        
    }
}



// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]


//T: 0(nklogk) klogk is for array
//S:0(nk)
//n -lenth og string arrays and to sort each st we take klogk

// defuine map string list
//iterate each str over array
//for each string
//conbvert to charArray and then sort and then convert back to string which acts a s a key
//now in map if key present  add the current string ur iterating else create a key with empty list and then add current string 
// once we fill all values we group all anagrams in list og map vaules map.values give s all values
//new Arraylist(map.values())--return list of lists