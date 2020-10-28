class Solution(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        sum = 0
        for n in range (1, num):
            if 0 == (num % n):
                sum += n
        return sum == num
        
