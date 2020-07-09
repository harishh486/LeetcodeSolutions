class Solution {
    public static void swap(int[] array, int firstIndex, int secondIndex) {
          
      int len = array.length;
      if (firstIndex <= len && secondIndex <= len)
      {
         int temp = array[firstIndex];
         array[firstIndex] = array[secondIndex];
         array[secondIndex] = temp;
      }
      return;
    } 

    
  }