class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        // need to lowercase and split using regex
        // one charcter that is not a word
        String split_words[] = paragraph.toLowerCase().split("\\W+");
        
        // we need a fast way to check whether a word is present in banned list or not 
        // hash set could be best one// can use contains method
        HashSet<String> banned_words = new HashSet();
        for(String s: banned)
            banned_words.add(s);
        
        HashMap<String, Integer> buildCountMap = new HashMap();
        for(String word: split_words){
            // before putting we need to check if its banned list, if so ..ignore them
            if(!banned_words.contains(word)){
                //put it into map
                // since we need other than banned words which is max
                buildCountMap.put(word,buildCountMap.getOrDefault(word,0)+1 );
            }
            
        }
        
        // now we build a map, what now--? classic max problem ??
        int max=0;
        String result = "";
        
        //now whe have a map,  String and its count--loop thru keys
        // is there any method for keys() or keySet() on maps--return array --us eit to traverse
        
        for(String word: buildCountMap.keySet()){
            if(buildCountMap.get(word) > max){
                //update max and update string word
                max = buildCountMap.get(word);
                result = word;
                
            }
            
        }
        
        
        
        return result;
        
        
        
    }
}



//T:o(n+m-linear loops --paragraph and banned 
//S:o(n+m-linear loops --to store count and banned set