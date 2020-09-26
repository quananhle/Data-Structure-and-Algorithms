## Add Strings

__Difficulty__: Green

Given two non-negative integers ```num1``` and ```num2``` represented as string, return the sum of ```num1``` and ```num2```.

__Note__:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

__Input__: "345" "543"
__Output__: "888"

#### Algorithm

* Initialize an empty res structure. Once could use array in Python and StringBuilder in Java.

* Start from carry = 0.

* Set a pointer at the end of each string: p1 = num1.length() - 1, p2 = num2.length() - 1.

* Loop over the strings from the end to the beginning using p1 and p2. Stop when both strings are used entirely.

    Set x1 to be equal to a digit from string nums1 at index p1. If p1 has reached the beginning of nums1, set x1 to 0.

    Do the same for x2. Set x2 to be equal to digit from string nums2 at index p2. If p2 has reached the beginning of nums2, set x2 to 0.

    Compute the current value: value = (x1 + x2 + carry) % 10, and update the carry: carry = (x1 + x2 + carry) / 10.

    Append the current value to the result: res.append(value).

* Now both strings are done. If the carry is still non-zero, update the result: res.append(carry).

* Reverse the result, convert it to a string, and return that string.

