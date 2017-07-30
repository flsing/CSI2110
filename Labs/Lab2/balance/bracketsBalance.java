/*  CSI2114 Lab 3 - lab3.java
 *  
 *  Class to check balanced brackets in math expressions  
 *
 *  Usage: java bracketsBalance <exp>
 *  
 *  by Jeff Souza
 *
 */

class bracketsBalance {

    private boolean bBalance (String exp){ 

        final String opening = "([{";
        final String closing = ")]}";
        Stack buffer = new ArrayStack();
        for(char c: exp.toCharArray()){
        	if (opening.indexOf(c)!= -1)
        		buffer.push(c);
        	
        	else if(closing.indexOf(c)!=-1)
        		if (buffer.isEmpty())
        			return false;
        	
        	if(closing.indexOf(c)!= opening.indexOf((char) buffer.pop()))
        			return false;
        	}
        		

        return buffer.isEmpty();

    }

    public static void main(String[] args) {

        bracketsBalance b = new bracketsBalance();
        boolean result = b.bBalance(args[0]);
   
        if (result) System.out.println("The expression is balanced."); 
        else        System.out.println("The expression is NOT balanced."); 
    }
}