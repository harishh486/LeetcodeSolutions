class Solution(object):
    def twoSum( nums, target):
        dict = {}
        for i in range(len(nums)):
            if dict.get(target-nums[i]) is not None:
                return [dict.get(target-nums[i]), i]
            else:
                dict[nums[i]]=i

    if __name__ == '__main__':
        num = [2,7,6,5]
        
        x = twoSum( num, 9)
        print(x)


# same logic 0(n)