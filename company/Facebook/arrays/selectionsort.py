class Solution(object):


    def indexOfMinimum(array, startIndex):  
        minValue = array[startIndex]
        minIndex = startIndex
        for i in range(minIndex + 1,len(array)):
            if array[i] < minValue:
                minIndex = i
                minValue = array[i]
        return minIndex
    
    
    def swap(array, firstIndex, secondIndex):
        temp = array[firstIndex]
        array[firstIndex] = array[secondIndex]
        array[secondIndex] = temp

    def selectionSort(array):
        for i in range(len(array)):
            x = indexOfMinimum(array, i)
            swap(array,i,x)
        print(array)


    


    if __name__ == '__main__':
        num = [2,7,6,5]
        
        x = selectionSort( num)
        print(x)


# same logic 0(n)