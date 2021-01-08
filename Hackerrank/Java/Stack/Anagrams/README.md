
## [Anagrams](https://www.hackerrank.com/challenges/java-anagrams/problem?h_r=profile)

__Code__: Green

Time complexity 0(N) using HashMap

```{Java}
    static boolean isAnagram(String a, String b) {
        // Complete the function
        // Make sure the length of 'a' and 'b' is the same; otherwise, return false
        assert(a.length() == b.length());
        java.util.Map<Character, Integer> counterA 
                        = new java.util.HashMap<>();
        java.util.Map<Character, Integer> counterB 
                        = new java.util.HashMap<>();
        // Loop through the length of 'a'                
        for (int i=0; i < a.length(); ++i){
            // Check if the character of 'a' at index i already in hash map
            // If exsisted, get its value and store to count; otherwise initialize 0 to count
            int count = counterA.containsKey(a.toLowerCase().charAt(i))
             ? counterA.get(a.toLowerCase().charAt(i)) : 0;
            // Increment the value of key character of 'a' at index i
            counterA.put(a.toLowerCase().charAt(i), count + 1);
        }
        // Loop through the length of 'b'
        for (int i=0; i < b.length(); ++i){
            // Check if the character of 'b' at index i already in hash map
            // If exsisted, get its value and store to count; otherwise initialize 0 to count
            int count = counterB.containsKey(b.toLowerCase().charAt(i))
             ? counterB.get(b.toLowerCase().charAt(i)) : 0;
             // Increment the value of key character of 'a' at index i
            counterB.put(b.toLowerCase().charAt(i), count + 1);
        }
        // Compare all elements in both hash maps
        return counterA.equals(counterB);
    }
```

Time complexity 0(N)LOG(N) using Arrays.sort()

```{Java}
    static boolean isAnagram(String a, String b) {
        // Complete the function
        assert(a.length() == b.length());
        char[] arrayA = a.toLowerCase().toCharArray();
        char[] arrayB = b.toLowerCase().toCharArray();
        java.util.Arrays.sort(arrayA);
        java.util.Arrays.sort(arrayB);
        return java.util.Arrays.equals(arrayA, arrayB);
    }
```
