class Solution(object):
    def indexOfMinimum(array, startIndex):  
        minValue = array[startIndex]
        minIndex = startIndex
        for i in range(minIndex + 1,len(array)):
            if array[i] < minValue:
                minIndex = i
                minValue = array[i]
        return minIndex

    if __name__ == '__main__':
        num = [2,7,6,5,1]
        
        x = indexOfMinimum( num, 0)
        print(x)


# same logic 0(n)