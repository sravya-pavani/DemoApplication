package testCasesFiveAndSix;

public class MainClassForTestCaseFiveAndSix 
{		
	public static void main (String[] args)
	{
		try
		{	
			//Test Case 5 Execution
			
			System.out.println("Test Case 5 Execution");
			MethodForPrintingNum testCaseFiveObj = new MethodForPrintingNum();
			testCaseFiveObj.findMultiples(100);
				
			//Test Case 6 Execution
			
			System.out.println("Test Case 6 Execution");			
			MethodsForAreaCalculation.Triangle triObj  = new MethodsForAreaCalculation.Triangle(10, 21);
			triObj.calculateArea();
			MethodsForAreaCalculation.Rectangle rectObj = new MethodsForAreaCalculation.Rectangle(24, 12);
			rectObj.calculateArea();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}