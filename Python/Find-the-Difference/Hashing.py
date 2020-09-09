from collections import Counter
class Hashing(object):
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        # Prepare a counter for string s.
        # This holds the characters as keys and respective frequency as value.
        counter_s = Counter(s)
        # Iterate through string t and find the character which is not in s.
        for ch in t:
            if ch not in counter_s or counter_s[ch] == 0:
                return ch
            else:
                # Once a match is found we reduce frequency left.
                # This eliminates the possibility of a false match later.
                counter_s[ch] -= 1
