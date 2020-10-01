class Solution {
    public int[][] highFive(int[][] items) {
        // List<Integer> gradeList = new ArrayList<>();
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] item : items){
            /*
            getOrDefault(Object key, V defaultValue) returns value mapped with specified key. If no value is mapped with the provided key then the default value is returned
            */
            List<Integer> gradeList = map.getOrDefault(item[0], new ArrayList<>());
            gradeList.add(item[1]);
            /*
            put(K key,V value) returns the previous value associated with key, or null if there was no mapping for key. (A null return can also indicate that the map previously associated null with key, if the implementation supports null values.)
            */
            map.put(item[0], gradeList);
        }
        System.out.print(map);
        int totalStudents = map.keySet().size();
        int[][] result = new int[totalStudents][2];
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            //key is studentID
            int studentID = entry.getKey();
            //value is grade
            List<Integer> studentScores = entry.getValue();
            //sort grades in decreasing order
            Collections.sort(studentScores, Collections.reverseOrder());
            int sum = 0;
            //only take top 5 scores, or less if applicable, into account
            for(int i = 0; i < Math.min(5, studentScores.size()); ++i){
                sum += studentScores.get(i);
            }
            result[count][0] = studentID;
            result[count][1] = sum / 5;
            count++;
        }
        return result;
    }
}
