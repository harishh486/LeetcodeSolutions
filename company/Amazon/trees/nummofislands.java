class Solution {
    public int numIslands(char[][] grid) {
        
        // check the edge cases
        if(grid.length == 0)
            return 0;
        
        int numislands = 0;  
        
        // logic is to traverse thru the grid like a regular matrix problm 
        // if u encounter 1 do:
        //  incremnet th islands as soon as u encounter the 1
        //  and visit all neighbours using bfs and turn them into 0/2 so that u dont visit again
        // visiting all neighbours --seems like a bfs/dfs graph problem so we can use dfs since w e might use recursion to travel the nodes
        // grid.length--rows count
        // grid[0].length --no of colummns
        for(int i=0; i <grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){

                    //Count the number of nodes that trigger DFS, 
                    //this number would be the number of islands since each DFS starting at some node identifies an island.
                    numislands++;
                    dfsAdj(grid, i, j);
                }
            }
        }

        return numislands;

    }
    
    
    
    private void dfsAdj(char[][] grid, int i, int j){
        
        // check boundaries and also check. if its zero
        // check the lengths correctly
        if(i<0 || j<0 || i>grid.length -1 || j > grid[0].length-1 || grid[i][j] =='0')
            return;
        // we ll just make 1's to zeros for every visiting node
        
        grid[i][j]='0';
        
        //visiting
        dfsAdj(grid, i+1, j);//up
        dfsAdj(grid, i-1, j);// down
        dfsAdj(grid, i, j+1);// right
        dfsAdj(grid, i, j-1);// left
        
        
    }
}


T: O(MN) where m is the number of rows and n is the number of columns.

S: : worst  O(MN)-- that the grid map is filled with lands stack recursion stores all stack of (mn)