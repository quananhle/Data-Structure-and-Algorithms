class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # The stack to keep track of opening brackets.
        stack = []
        open_par = set(["(", "[", "{"])
        # Hash map for keeping track of mappings. This keeps the code very clean.
        # Also makes adding more types of parenthesis easier
        mapping = {"(": ")", "{" : "}", "[":"]"}   
        #for every bracket in the expression s
        for i in s:
            #check if element i belongs to set of open parentheses
            #if the character is an open bracket
            if i in open_par:
                #push it onto the stack
                stack.append(i)
            #check if list is not empty and there is a close bracket for the open bracket 
            #pop the topmost element from stack
            elif stack and i == mapping[stack[-1]]:
                stack.pop()
            else:
                #otherwise, elements don't match, return false
                return False
        # In the end, if the stack is empty, then we have a valid expression.
        # The stack won't be empty for cases like ((()
        #return not stack    
        return stack == []
