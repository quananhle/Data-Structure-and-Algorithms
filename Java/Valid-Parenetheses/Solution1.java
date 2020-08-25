class Solution {
    //initialize a hash table for mappings
    private HashMap<Character, Character> mappings;
    //constructor
    public Solution() {
        //initialize hash map for keeping tracking of mappings
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public boolean isValid(String s) {
        //initialize a stack
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            //for every bracket in the expression
            char c = s.charAt(i);
            // if the character is a closing bracket
            if (this.mappings.containsKey(c)) {
                /**
                if stack.isEmpty() {
                    char topElement = '#';
                }
                else {
                    stack.pop();
                }
                **/
                // get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                // if the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            }
            //otherwise, if it was an opening bracket, push to the stack.
            else {
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
