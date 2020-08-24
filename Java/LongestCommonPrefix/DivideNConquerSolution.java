class DivideNConquerSolution {
    public String longestCommonPrefix(String[] strs) {
        //special case, if the array is empty
        if (strs.length == 0 || strs == null) {
            //return an empty string ""
            return "";
        }
        return lCP(strs, 0, strs.length - 1);
    }
    public String lCP(String[] strs, int left, int right) {
        //special case, if the array has only one element
        if (left == right) {
            return strs[left];
        }
        else {
            //mid point of the array
            int mid = (left + right) / 2;
            //left subarray
            String lcpLeft = lCP(strs, left, mid);
            //right subarray
            String lcpRight = lCP(strs, mid+1, right);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }
    public String commonPrefix(String left, String right) {
        //only care about the shortest element between the two elements
        int min = Math.min(left.length(), right.length());
        //loop only as long as the shorter element
        for (int i = 0; i < min; i++) {
            //until the prefix is no longer in common
            if(left.charAt(i) != right.charAt(i)) {
                //return the the common prefix
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
