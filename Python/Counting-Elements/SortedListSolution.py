class SortedListSolution(object):
    def countElements(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        arr.sort()
        count = 0
        #run_length keep track of number of duplicate items in each group
        run_length = 1
        #loop in range length of arr
        for i in range(len(arr)):
            #detect the duplicate elements
            #if the element at idx i is not the same as the element at idx i-1
            if arr[i-1] != arr[i]:
                #as arr is sorted, x+1 is placed next to x in sorted(arr)
                if arr[i-1] + 1 == arr[i]:
                    #increment count for duplicate items
                    count += run_length
                #otherwise, element has no duplicate, reset run_length
                run_length = 0
            #otherwise, there are duplicates
            run_length += 1
        return count
