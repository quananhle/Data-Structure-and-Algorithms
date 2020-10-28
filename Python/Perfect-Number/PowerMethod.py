class PowerMethod(object):
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        sum_n = 0
        n = 1
        while n*n <= num:
            if 0 == num % n:
                sum_n += n
                if n*n != num:
                    sum_n += num / n
            n += 1
        return sum_n - num == num
