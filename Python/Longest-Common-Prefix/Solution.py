class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        #special cases, list is empty
        if not strs:
            return ""
        #list has only an element
        elif len(strs) == 1:
            return strs[0]
        #sort the list
        else:
            strs.sort()
            #initialize an empty string
            s = ""
            #zip the first and last elements together and loop
            for x, y in zip(strs[0], strs[-1]):
                #compare
                if x == y:
                    s += x
                else:
                    return s
            return s
