values = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000,}
class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        total = 0
        #pointer
        #loop through the length of the enumerate of string
        for idx, numeral in enumerate(s):
            #if at least 2 symbols remaining AND value of numeral < value of s[idx+1]
            if idx < len(s) - 1 and values[numeral] < values[s[idx+1]]:
                #deduct the value of s[i] from total
                total -= values[numeral]
            #not the subtractive case, add up the value of numeral:
            else:
                total += values[numeral]
        return total
