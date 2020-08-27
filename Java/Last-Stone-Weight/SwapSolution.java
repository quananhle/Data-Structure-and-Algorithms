class SwapSolution {
    private int removeLargest(List<Integer> stones) {
        //get the index of the largest element
        int indexOfLargest = stones.indexOf(Collections.max(stones));
        //get the value of the largest element
        int result = stones.get(indexOfLargest);
        //get the value of last element and replace it with the largest element
        stones.set(indexOfLargest, stones.get(stones.size() - 1));
        //remove the last element or largest element
        stones.remove(stones.size() - 1);
        return result;
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        //for each element in array stones
        for (int weight : stones) {
            //add to the arrayList stoneList
            stoneList.add(weight);
        }
        //loop as long as the size of the lise is no bigger than 1
        while (stoneList.size() > 1) {
            //remove the heaviest stone from stoneList and store it to stone1
            int stone1 = removeLargest(stoneList);
            //remove the heaviest stone from stoneList and store it to stone2
            int stone2 = removeLargest(stoneList);
            //if stone1 and stone2 do not have the same weight
            if (stone1 != stone2) {
                int newStone = stone1 - stone2;
                //add the new stone
                stoneList.add(newStone);
            }
        }
        //if stoneList is not empty, return first element in stoneList; otherwise, return 0
        return !stoneList.isEmpty() ? stoneList.remove(0) : 0;
    }
}
