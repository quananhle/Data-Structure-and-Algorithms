class LoopSolution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """       
        # 123 = 1+2+3 = 6    
        # if 123 // 10 = 12 > 0    
        #     123 // 10 = 12
        #     123 % 10 = 3
        #     if 12 // 10 = 1 < 10
        #         12 % 10 = 2
        #         12 // 10 = 1     
        #with loop solution
        output = 0
        while num > 0:
            output += num % 10
            num = num // 10
            if (output // 10 < 10) or (num == 0 and output > 9):
                # output = output // 10 + output % 10
                num = output
                output = 0                
        return output
