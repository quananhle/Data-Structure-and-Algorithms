class Solution:
    def split(self, message):  
        lastSpace = 0
        curStart = 0
        ans = []
        totalSplit = 0
        count = 0
        i = 0
        while i < len(input1):
            count += 1
            if input1[i] == ' ':
                lastSpace = i
            if count == 155:
                if input1[i] != ' ':
                    if (i < len(message) - 1 and message[i+1] == ' ') or i == len(message) - 1:
                        lastSpace = i
                totalSplit += 1
                count = 0
                ans.append(message[curStart:lastSpace+1])
                if i > lastSpace:
                    i = lastSpace
                curStart = i + 1
            i += 1
        if curStart < len(message):
            if totalSplit == 0:
                return [input1]
            ans.append(input1[curStart:])
            totalSplit += 1
        
        for i, s in enumerate(ans):
            ans[i] = s + '(' + str(i+1) + '/' + str(totalSplit) + ')'
        return ans
