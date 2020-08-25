class Solution {
    //initialize a hash table for mappings
    private HashMap<Character, Character> mappings;
    private HashSet<Character>openPar;
    public Solution() {
        //initialize hash map for keeping tracking of mappings
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put('(',')');
        this.mappings.put('{','}');
        this.mappings.put('[',']');
        //initialize set for storing open brackets
        this.openPar = new HashSet<Character>();
        this.openPar.add('(');
        this.openPar.add('{');
        this.openPar.add('[');
    }
    public boolean isValid(String s) {
        //initialize a stack
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            //for every bracket in the expression
            char c = s.charAt(i);
            //if the current character is an open bracket.
            if (this.openPar.contains(c)) {
                //push to the stack
                stack.push(c);
            }
            //if the stack is non empty AND the current character match the top element of the stack
            else if (!stack.empty() && c == this.mappings.get(stack.lastElement())) {
                //get the top element of the stack
                stack.pop();
            } else {
                //if the mapping for this bracket doesn't match the stack's top element, return false.
                return false;
            }
        }
        //if the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
