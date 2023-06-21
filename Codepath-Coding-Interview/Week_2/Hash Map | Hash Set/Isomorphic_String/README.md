## [205. Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings)

```Tag```: ```Hash Map``` ```Hash Set```

#### Difficulty: Easy

Given two strings ```s``` and ```t```, determine if they are isomorphic.

Two strings ```s``` and ```t``` are isomorphic if the characters in ```s``` can be replaced to get ```t```.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

![image](https://github.com/quananhle/Data-Structure-and-Algorithms/assets/35042430/d5225cf2-11cb-4ea8-b4b2-b8443b91e4b8)

---

__Example 1:__
```
Input: s = "egg", t = "add"
Output: true
```

__Example 2:__
```
Input: s = "foo", t = "bar"
Output: false
```

__Example 3:__
```
Input: s = "paper", t = "title"
Output: true
```

__Constraints:__

- ```1 <= s.length <= 5 * 10^4```
- ```t.length == s.length```
- ```s``` and ```t``` consist of any valid ascii character.

---

### Hash Map

```Python
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_counter = collections.defaultdict()
        t_counter = collections.defaultdict()

        for c_s, c_t in zip(s, t):
            if not c_s in s_counter:
                s_counter[c_s] = c_t
            else:
                if s_counter[c_s] != c_t:
                    return False

            if not c_t in t_counter:
                t_counter[c_t] = c_s
            else:
                if t_counter[c_t] != c_s:
                    return False

        return True
```

```Python
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s_counter = collections.defaultdict()
        t_counter = collections.defaultdict()
        
        for c_s, c_t in zip(s, t):
            
            # Case 1: No mapping exists in either of the dictionaries
            if (not c_s in s_counter) and (not c_t in t_counter):
                s_counter[c_s] = c_t
                t_counter[c_t] = c_s
            
            # Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            # it doesn't match in either of the dictionaries or both            
            elif s_counter.get(c_s) != c_t or t_counter.get(c_t) != c_s:
                return False
            
        return True
```

### Hash Set

#### One Liner

```Python
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(s) == len(t) and len(set(s)) == len(set(t)) == len(set(zip(s, t)))
```
