values = {
    "I": 1,
    "V": 5,
    "X": 10,
    "L": 50,
    "C": 100,
    "D": 500,
    "M": 1000,
}

class RightToLeftSolution:
    def romanToInt(self, str):
        total = values.get(str[-1])
        for i in (range(len(str) - 1)):
            if values[str[i]] < values[str[i + 1]]:
                total -= values[str[i]]
            else:
                total += values[str[i]]
        return total
