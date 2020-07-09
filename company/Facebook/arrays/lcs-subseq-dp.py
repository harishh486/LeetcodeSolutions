class Solution(object):
    def lcs( X,Y):
        m = len(X)
        n = len (Y)
        # Array declaration is tricky
        L = [[0] * (n+1)] *  (m+1)
        #array of m+1 * n+1 whose values are 0's [[0,0...0], [0,0...0]....[0,0..0]] 

        for i in range(m+1):
            for j in range(n+1):
                if i == 0 or j == 0:
                    L[i][j] = 0;
                elif X[i-1] == Y[j-1]:
                    L[i][j] = 1 + L[i-1][j-1];
                else:
                    L[i][j] = max( L[i-1][j], L[i][j-1])
        
        return L[m][n];
        #return last value in the tabular method of dp problem
    

    def lcs2(X,Y):
        m = len(X)
        n = len (Y)
        memo = [0] * (n+1)
        for i in range(1,m):
            prev = 0;
            for j in range(1, n):
                temp = memo[j];
                if X[i-1] == Y[j-1]:
                    memo[j] = prev + 1;
                else:
                    memo[j] = max(memo[j], memo[j - 1]);
                prev = temp;
        return memo[n];

        






    if __name__ == '__main__':
        X = "AGGTAB"
        Y = "GXTXAYB"
        print("Length of LCS is", lcs2(X, Y))



# time complexity o(mn):  2 pwr n to mn from recursion to dp
     #other way of 2d array declaration
     #good way
        # a = [0] * n
        # for i in range(n):
        # a[i] = [0] * m


