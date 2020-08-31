class HashTable {
    public int singleNumber(int[] nums) {
        //initialize a hash object contains int-typed key and int-typed value
        HashMap<Integer, Integer> hash_table = new HashMap<>();
        //for each int num in array nums
        for (int num : nums) {
            //put num in the hash_table as key, and iterate value with default value 0 if duplicate num is found
            hash_table.put(num, hash_table.getOrDefault(num, 0) + 1);
        }
        //for each int key in array nums
        for (int key : nums) {
            //check if key has value = 1
            if (hash_table.get(key) == 1) {
                //return key
                return key;
            }
        }
        return 0;
    }
}
