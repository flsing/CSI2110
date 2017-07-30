/*  CSI2114 Lab 3 - lab3.java
 *  
 *  Class to check balanced brackets in math expressions  
 *
 *  Usage: java bracketsBalance <expression>
 *  
 *  by Jeff Souza and Livaniaina Rakotomalala
 *
 */

class bracketsBalance {

    // checks balanced brackets in exp (the expression)
    private boolean bBalance (String exp){

        //Create a new stack
        ArrayStack stk = new ArrayStack(10);
        // the bracket pairs
        String brackets = "(){}[]";

        //Scan across expression
        for (int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);
            int inputPos = brackets.indexOf(ch);

            //Push an opening bracket onto the stack
            if (inputPos % 2 == 0){
               try{
                 stk.push (new Character(ch));
               }
               catch(StackFullException e){
               }
            }
            //Process a closing bracket
            else if (inputPos != -1){
                //If stack empty, then error
                if (stk.isEmpty())
                    return false;

                // Retrieve bracket from stack
                char charFromStack='\0';
                try{
                  charFromStack = ((Character)stk.pop()).charValue();
                }
                catch(StackEmptyException e){
               }

                int stackedPos = brackets.indexOf(charFromStack);
                //If the opening and closing brackets are of different types, then error
                if (stackedPos+1 != inputPos)
                    return false;
            }
        }

        //If the stack is empty then no error, else error
        return stk.isEmpty();

    }

    public static void main(String[] args) {

        bracketsBalance b = new bracketsBalance();
        boolean result = b.bBalance(args[0]);
   
        if (result) System.out.println("The expression is balanced."); 
        else        System.out.println("The expression is NOT balanced."); 
    }
}