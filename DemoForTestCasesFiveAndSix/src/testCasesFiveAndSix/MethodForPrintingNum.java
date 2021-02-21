package testCasesFiveAndSix;

public class MethodForPrintingNum
{
	public void findMultiples (int n)
	{
	        // loop iterating through 1 to 100
	        for (int i = 1; i <= n; i++) 
		    {
	    	  
	    	  String s = "";
	    
	    	  // To check the number is a multiple of 3 
	    	  if (i % 3 == 0)
	    	    {
	    	        //Rename multiple of 3 to MThree
	    	        s = "MThree"; 
	    	    }
	    
	    	  // To check the number is multiple of 5 
	    	  if (i % 5 == 0)
	    	    {
	    	        //Rename multiple of 5 to MFive
	    	        s = "MFive"; 
	    	    }
	    	    
	    	   //To check the number is a multiple of both 3 and 5
	    	  if (i % 3 == 0 && i % 5 == 0)
	    	    {
	    	        //Rename the number to Resolver
	    	        s = "Resolver"; 
	    	    }
	    	    
	    	    //print the number 
	    	  if (s == "")
	    	    System.out.println (i);
	    	  else
	    	    System.out.println (s);
		    }
	    }
}




