class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c  == '['){
                stack.push(c);
            }
            else if(c == ')'){
                if (stack.isEmpty()) return false;
                char cs = stack.pop();
                if (cs != '('){
                    return false;
                }
            }
            else if(c == '}'){
                if (stack.isEmpty()) return false;
                char cs = stack.pop();
                if (cs != '{'){
                    return false;
                }
            }
            else if(c == ']'){
                if (stack.isEmpty()) return false;
                char cs = stack.pop();
                if (cs != '['){
                    return false;
                }
            }
            else{
                continue;
            }
        }
        return stack.isEmpty();
        
    }
}
