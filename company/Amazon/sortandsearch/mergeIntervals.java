class Solution {
    public int[][] merge(int[][] intervals) {
        
        
        // if the input is one or zero return intervals--no use to perform logic
        if(intervals.length <=1)
            return intervals;
        
        // now we need to soet the intervals becos it did not gave them it is sorted
        // need a custom object comparator to sort based on first element of array
        //[[1,3],[2,6],[8,10],[15,18]]
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0],arr2[0]));
        
        // create a list of arrays since u dont know the arr elements which might have merged so list is good option
        List<int[]> output_list = new ArrayList();
        // we ll add th initial value and then update the secon element of array after adding
        int[] current_arr = intervals[0];
        output_list.add(current_arr);
        //now weh ahve first element in list
        // [[1,3]]
        // logic is compare the second element of first array with first element of second array
        // [[1,3],[2,6]]
        for(int arr[]  : intervals){
            int currentarr_start = current_arr[0];
            int currentarr_end = current_arr[1];
            int nextarray_start = arr[0];
            int nextarray_end = arr[1];
            
            if(currentarr_end >= nextarray_start){
                // merge interval
                current_arr[1]  = Math.max(currentarr_end, nextarray_end);
                
            }
            else {
                current_arr = arr;
                output_list.add(current_arr);
            }
            
        }
        
        return output_list.toArray(new int[output_list.size()][]);
        
        
    }
}


// T: sort--o(nlogn)
// S: 0(1)

// siince we use sorting-- quick sort --arrays.sort()

//Arrays.sort method uses Quicksort for arrays of primitives and merge sort for arrays of objects.

//So, in the end, Collections#sort uses Arrays#sort (of object elements) behind the scenes. This implementation uses merge sort or tim sort. 
//According to the Javadoc, only primitive arrays are sorted using Quicksort. Object arrays are sorted with a Mergesort as well