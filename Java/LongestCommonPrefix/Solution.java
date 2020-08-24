class Solution {
    public String longestCommonPrefix(String[] strs) {
        //special case, if the array is empty
        if (strs.length == 0) {
            //return an empty string ""
            return "";
        }
        //Pointer to the first string amongst the array
        String str = strs[0];
        //Loop through the array
        for (int i = 1; i < strs.length; i++) {
            //Loop as long as the prefix is common
            while(strs[i].indexOf(str) != 0) {
                //Store the substring
                str = str.substring(0, str.length() - 1);
                //If there is no common prefix
                if (str.isEmpty()) {
                    //return an empty string ""
                    return "";
                }
            }
        }
        return str;
    }
}
