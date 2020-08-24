class VerticalSolution {
    public String longestCommonPrefix(String[] strs) {
        //special case, if the array is empty
        if (strs.length == 0 || strs == null) {
            //return an empty string ""
            return "";
        }
        //Loop through the first string amongst the array
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            //Loop through array starting from the second string
            for (int j = 1; j < strs.length; j++) {
                //check the prefix OR check until the character at index i of strs[j] is not the same as character at index i of the first string strs[0] 
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    //Store the substring
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
