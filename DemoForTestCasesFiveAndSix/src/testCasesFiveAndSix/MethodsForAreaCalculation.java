package testCasesFiveAndSix;

//import testCasesFiveAndSix.MainClassForTestCaseFiveAndSix.shape;

public class MethodsForAreaCalculation {
	
	public static class shape 
	{
		double width ;
		double height;
		//constructor giving values to width and height 
		public shape (double wid, double hei)
		{
		width = wid;
		height = hei;
		}	
	}
	
	public  static class Triangle extends shape
	{
		public Triangle(double wid, double hei)
		{
			super(wid, hei);
		}
		public void calculateArea() 
		{
			double area = (double)(width * height )/2;			
			System.out.println("The area of triangle is " + area);
		}
	}
	
	public  static class Rectangle extends shape
	{
		public Rectangle(double wid, double hei)
		{
			super(wid, hei);
		}
		public void calculateArea() 
		{
			double area = (double)(width * height );
			System.out.println("The area of Rectangle is " + area);
		}
	}
}
