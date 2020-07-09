class Solution(object):
    def longestsubsequnce(X, Y, m, n):
        print("hello")
        if m == 0 or n == 0:
           return 0;
        elif X[m-1] == Y[n-1]:
            return 1 + longestsubsequnce(X,Y, m-1, n-1);
        else:
           return max(longestsubsequnce(X,Y,m,n-1), longestsubsequnce(X,Y,m-1,n))
        

    
    if __name__ == '__main__':
        X = "AGGTAB"
        Y = "GXTXAYB"
        W = longestsubsequnce("AGGTAB", "GXTXAYB",6,7)
        print(W)




# import functools
# class Solution:
#     def longestCommonSubsequence(self, text1: str, text2: str) -> int:
#         @functools.lru_cache(None)
#         def helper(i,j):
#             if i<0 or j<0:
#                 return 0
#             if text1[i]==text2[j]:
#                 return helper(i-1,j-1)+1
#             return max(helper(i-1,j),helper(i,j-1))
#         return helper(len(text1)-1,len(text2)-1)