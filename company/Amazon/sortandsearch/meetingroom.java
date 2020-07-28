class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        // sort like merge intervals
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0],arr2[0]));

        for(int i=0; i< intervals.length-1; i++){
            if(intervals[i][1] > intervals[i+1][0] )
                return false;
        }
        return true;
    }
}



// similar to merge intervals

//  sort it and then comoare arr[][0] to arr2[] [1] --element

// //but we need to chnage the compariuson, if we merge the interval retun false
// //  else retun true


// T: onlogn
// s; o(1)