class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        // Visulaize like a graph so that u ll get some intuition
        // it is like from a given node reach out the nodes which has same color and chnage to new color
        // traverse from one node to all nodes in graph usig bfs/dfs and chnage  the image
        // since it is matrix we will use dfs to recursive calls to traverse up, down ,left and right
        //easy technique
        
        
        // Base cases: if src == new color then do nothing and return image
        if(image[sr][sc] == newColor)
            return image;
        
        fill (image, sr,sc, image[sr][sc], newColor);
        return image;
        
    }
    
    void fill(int[][] image, int sr, int sc, int initialcolor, int newColor){
        
        // check the boundaries for the edge cases for indices
        //check also if the color that we are processing is not what we wanted::so dont touch them
        
        // TIP: Always always compare boundary index first then actual condition next otherwise u ll get array out of index exceptions in some cases
        if(sr <0 || sc < 0 || sr > image.length-1 || sc > image[0].length-1 || image[sr][sc] != initialcolor ) 
            return; // do nothing just return
        
        // chnage the color
        image[sr][sc] = newColor;
        fill (image, sr+1,sc, initialcolor, newColor);
         fill (image, sr-1,sc, initialcolor, newColor);
         fill (image, sr,sc+1, initialcolor, newColor);
         fill (image, sr,sc-1, initialcolor, newColor);
 
    }
}



// T: 0(N) is the number of pixels in the image. We might process every pixel.

// S: O(N), the size of the implicit call stack when calling dfs.