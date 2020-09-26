## Add Digits

**Difficulty**: Green

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

**Example**:

**Input**: 38
**Output**: 2 
**Explanation**: The process is: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

### FancySolution.py

**Mathematical**: Digital Root

Formula for the Digital Root

There is a known formula to compute a digital root in a decimal numeral system

dr<sub>10</sub>(n) = 0, if n = 0 

dr<sub>10</sub>(n) = 9, if n = 9k 

dr<sub>10</sub>(n)= n mod 9, if n ≠ 9k 

### Complexity Analysis

    Time Complexity: O(1)

    Space Complexity: O(1)
