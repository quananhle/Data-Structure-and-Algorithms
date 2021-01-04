Forming a Magic Square

https://www.hackerrank.com/challenges/magic-square-forming/forum


Orange


```{Python}
def formingMagicSquare(s):
    # to form all possible 3 x 3 magic squares 
    magic_squares = []
    for i in range (1,10):
        for j in range (1,10):
            #  the magic constant of each row, column, and diagonal in a 3 x 3 magic square is 15
            magic_square = [i, 15-i-j, j, 5-i+j, 5, 5+i-j, 10-j, i+j-5, 10-i]
            # check if i and j are distinct
            if set(magic_square) == set(range(1,10)):
                magic_squares.append(magic_square)
    # flatten the 2D input list into a 1D list
    input_square = []
    for i in range (len(s)):
        for j in s[i]:
            input_square.append(j)
    # compare the input square with all squares in magic_squares to find the minimal cost
    min_cost = sys.maxsize
    for magic_square in magic_squares:
        cost = 0
        for i in range (len(magic_square)):
            cost += abs(input_square[i] - magic_square[i])
        if cost < min_cost:
            min_cost = cost
    return min_cost
```
