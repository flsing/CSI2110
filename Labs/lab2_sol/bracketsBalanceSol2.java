/*  CSI2114 Lab 3 - lab3.java
 *  
 *  Class to check balanced brackets in math expressions  
 *
 *  Usage: java bracketsBalance <expression>
 *  
 *  by Wail Mardini
 *
 */

class bracketsBalanceSol2 {

    // checks balanced brackets in exp (the expression)
    private boolean bBalance (String exp){

        //Create a new stack
        ArrayStack stk = new ArrayStack(10);

		// the bracket pairs
		String lefts= "({[";
		String rights= ")}]";

		char ch=' ';
        //Scan across expression
		for (int i = 0; i < exp.length(); i++)		
		{
			System.out.print(ch);
			ch = exp.charAt(i);
			
			if(lefts.indexOf(ch)!=-1)
				try {
					stk.push(new Character(ch));
				}	
				catch(StackFullException e)
				{
				}
			else if(rights.indexOf(ch)!=-1)
			{
				char chFrmStk='\0';
				if(stk.isEmpty()) return false;
				chFrmStk = ((Character)stk.pop()).charValue();
				if(rights.indexOf(ch)!=lefts.indexOf(chFrmStk)) 
					return false;
			}

		}
        //If the stack is empty then no error, else error
        return stk.isEmpty();

    }

    public static void main(String[] args) {

        bracketsBalanceSol2 b = new bracketsBalanceSol2();
        boolean result = b.bBalance(args[0]);
   
        if (result) System.out.println("The expression is balanced."); 
        else        System.out.println("The expression is NOT balanced."); 
    }
}