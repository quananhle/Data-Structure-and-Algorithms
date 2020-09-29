def reverse_integer(num):
    prev_num = 0
    rev_num  = 0
    isNegative = False
    if num < 0:
        isNegative = True
        num = -num
    while num != 0:
        curr_digit = num % 10
        rev_num = rev_num*10 + curr_digit
        #overflow handler
        if ((rev_num - curr_digit) // 10) != prev_num:
            return 'Overflow, return 0 instead'
        prev_num = rev_num
        num = num // 10
    return (rev_num if not isNegative else -rev_num)
    
print(reverse_integer(123))
print(reverse_integer(-1000))
print(reverse_integer(4539))
print(reverse_integer(123134342312))
