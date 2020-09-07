class Sorting(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        i = 0
        while i < len(s):
            if sorted(s)[i] != sorted(t)[i]:
                return sorted(t)[i]
            i += 1
        return sorted(t)[i]
