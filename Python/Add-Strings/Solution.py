class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        output = []
        carry = 0
        p1 = len(num1) - 1
        p2 = len(num2) - 1
        print('Hello World')
        while p1 >= 0 or p2 >= 0:
            x1 = ord(num1[p1]) - ord('0') if p1 >= 0 else 0
            x2 = ord(num2[p2]) - ord('0') if p2 >= 0 else 0
            value = (x1 + x2 + carry) % 10
            carry = (x1 + x2 + carry) // 10
            output.append(value)
            p1 -= 1
            p2 -= 1
        if carry:
            output.append(carry)
        return ''.join(str(x) for x in output[::-1])
