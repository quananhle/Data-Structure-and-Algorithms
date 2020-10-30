class Euclid-EulerTheorem(object):
    def checkPerfectNumber(self, num):
        primes = [2,3,5,7,13,17,19,31]
        for prime in primes:
            if pn(prime) == num:
                return True
        return False

def pn(num):
    #a left shift by n bits is equivalent to multiplication by pow(2, n)
    return (1 << (num - 1)) * ((1 << num) - 1)    
        
