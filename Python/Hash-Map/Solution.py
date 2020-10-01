class Solution(object):
    def highFive(self, items):
        """
        :type items: List[List[int]]
        :rtype: List[List[int]]
        """
        d = dict()
        result = list()
        for student, score in items:
            if student in d:
                d[student].append(score)
            else:
                d[student] = [score]
        print(d)
        for key, value in d.items():
            d[key] = sorted(d[key], reverse=True)[:5]
            print(d[key])
            sum = 0
            for score in d[key]:
                sum += score
            result.append([key, sum//5])
        return result
        
