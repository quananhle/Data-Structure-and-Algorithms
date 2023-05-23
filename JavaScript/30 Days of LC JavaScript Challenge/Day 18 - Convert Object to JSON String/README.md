## [2633. Convert Object to JSON String](https://leetcode.com/problems/convert-object-to-json-string)

```Tag```: ```JSON / Recursion / Important Utilities```

#### Difficulty: Medium

Given an object, return _a valid JSON string of that object_. You may assume the object only inludes strings, integers, arrays, objects, booleans, and null. The returned string should not include extra spaces. The order of keys should be the same as the order returned by ```Object.keys()```.

Please solve it without using the built-in ```JSON.stringify``` method.

---

__Example 1:__
```
Input: object = {"y":1,"x":2}
Output: {"y":1,"x":2}
Explanation: 
Return the JSON representation.
Note that the order of keys should be the same as the order returned by Object.keys().
```

__Example 2:__
```
Input: object = {"a":"str","b":-12,"c":true,"d":null}
Output: {"a":"str","b":-12,"c":true,"d":null}
Explanation:
The primitives of JSON are strings, numbers, booleans, and null.
```

__Example 3:__
```
Input: object = {"key":{"a":1,"b":[{},null,"Hello"]}}
Output: {"key":{"a":1,"b":[{},null,"Hello"]}}
Explanation:
Objects and arrays can include other objects and arrays.
```

__Example 4:__
```
Input: object = true
Output: true
Explanation:
Primitive types are valid inputs.
```

__Constraints:__

- object includes strings, integers, booleans, arrays, objects, and ```null```
- ```1 <= JSON.stringify(object).length <= 10^5```
- ```maxNestingLevel <= 1000```
- all strings will only contain alphanumeric characters

---
