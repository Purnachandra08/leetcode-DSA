class Solution {
    public boolean isValid(String s) {
        Stack<Character> Stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch =='(' || ch == '{' || ch == '['){
                Stack.push(ch);
            }
            else{
                if(Stack.isEmpty()){
                    return false;
                }
                char top = Stack.peek();
                if(ch == ')' && top == '('){
                    Stack.pop();
                }
                else if(ch == '}' && top == '{'){
                    Stack.pop();
                }
                else if(ch == ']' && top == '['){
                    Stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return Stack.isEmpty();
    }
}