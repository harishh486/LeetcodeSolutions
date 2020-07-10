class Solution {
    public int compareVersion(String version1, String version2) {
        
        // initialize 2 integers where each store the numeric versions of given versions strings
        
        int numericV1=0;
        
        int numericV2=0;
        //loop. until. both strings are processed
        for(int i=0, j=0 ; (i< version1.length()  || j < version2.length()) ; i++,j++){
            
            
            //store numeric part of version one
            
            //take pne char part of string at a time and convbert tio int and compare one by one
            //take char which is not '.'
            while(i<  version1.length()  && version1.charAt(i) != '.'){
                numericV1 = numericV1*10 + (version1.charAt(i) -'0') ;
                i++;
                
            }
              while(j<  version2.length() && version2.charAt(j) != '.'){
                   numericV2 = numericV2*10 + (version2.charAt(j) -'0' );
                   j++;
            
            }
            if(numericV1 > numericV2) return 1; // if v1 >v2 positve 
            
            if(numericV1< numericV2) return -1;
            //if equal then proceed with other char conversion to digit
            //reset numbers
            numericV1=0;
            numericV2=0;
            // i++;
            // j++;
 
        }
        return 0;
        
    }
}

T: O(n), where n is the length of the string.
Only one traversal of the string is needed.
 s: O(1).
As no extra space is needed.



// class Solution {
//     public int compareVersion(String version1, String version2) {
//       String[] nums1 = version1.split("\\.");
//       String[] nums2 = version2.split("\\.");
//       int n1 = nums1.length, n2 = nums2.length;
  
//       // compare versions
//       int i1, i2;
//       for (int i = 0; i < Math.max(n1, n2); ++i) {
//         i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
//         i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
//         if (i1 != i2) {
//           return i1 > i2 ? 1 : -1;
//         }
//       }
//       // the versions are equal
//       return 0;
//     }
//   }

// // T  0(n+m)
// // S  0(n+m) two arrays
// //   --above is optimized
