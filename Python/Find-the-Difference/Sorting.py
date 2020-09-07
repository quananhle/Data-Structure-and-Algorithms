class Sorting(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        i = 0
        #loop as far as length of string s
        while i < len(s):
            #if the letter at index i of sorted string s is difference than the letter at index i of sorted string t
            if sorted(s)[i] != sorted(t)[i]:
                #return the letter in string t
                return sorted(t)[i]
            #increment one letter at at time
            i += 1
        #otherwise, the letter at the last index of sorted string t is the different letter
        return sorted(t)[i]
