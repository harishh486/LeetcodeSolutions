class Solution(object):
    def insertionsort(a):
        for i in range(1, len(a)):
            currentVal = a[i]
            position = i

            while position > 0 and a[position - 1] > currentVal:
                a[position] = a[position - 1]
                position = position - 1
            a[position] = currentVal

    
    if __name__ == '__main__':
        arr =[1,5,3,6]
        insertionsort(arr)
        print(arr)

#sliding window 