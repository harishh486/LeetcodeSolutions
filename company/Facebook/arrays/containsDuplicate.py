class Solution(object):
    def containsDuplicate(nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        return len(set(nums)) != len(nums)
    
    if __name__ == '__main__':
        num = [2,7,6,5,5]
        
        x = containsDuplicate( num)
        print(x)

# if set--no duplicates