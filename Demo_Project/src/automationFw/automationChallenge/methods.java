package automationChallenge;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;

//class having all the method implementations
public class methods {
	WebDriver driver ;
	JavascriptExecutor jspScroll;
	
	//JavascriptExecutor to scroll te page down
	public void scrollPage(int scrollPoint) {
		jspScroll = (JavascriptExecutor)driver;
	    jspScroll.executeScript("scroll(0, "+ scrollPoint + ")");
	}
	
	//class to verify the comboBox as well as to check the search results in it 
	public void selectComboValue(int print) {
		try {				
				//check the search result with 'angular' is 'angular' and 'angular 2' 
				//then print the test passed or failed
				if(print == 1)
				{			
					String firstListData = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[4]")).getText();
					String secondListData = driver.findElement(By.xpath("//*[@id='test-2-div']/div/div/ul/li[5]")).getText();
					if(firstListData.equals("Angular 2") && secondListData.equals("Angular"))
						System.out.println("Test case 2 passed with the search data 'angular'");					
					else
						System.out.println("Test case 2 failed with the search data 'angular'");				
				}
				
				//check the search result with 'ReactJs' is 0 
				//then print the test passed or failed
				else if(print == 2)
				{					
					List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='test-2-div']/div/div/ul/li")); 
					int emptyList = 0;
					for (WebElement element: allElements) {					    
						if(!element.getText().equals(""))
						{
							emptyList++;							
						}
					}
					if(emptyList == 0)
						System.out.println("Test case 2 passed with the search data 'ReactJs'");					
					else
						System.out.println("Test case 2 failed with the search data 'ReactJs'");
				}
		} 
		catch (Exception e) 
		{			
			System.out.println(e.getMessage());
		}
	}
	
	//class to verify table rows
	public void verifyTableRow(int checkRowCount) 
	{
		try {									
			if(checkRowCount == 2)
			{
				List<WebElement> rows = driver.findElements(By.xpath("//*[@id='someTable']"));				
				int rowCount = rows.size() + 1;
				
				if(rowCount == 2)
				{					
					String firstRowData = driver.findElement(By.xpath("//*[@id='someTable']/tr[1]/td[3]")).getText();
					String secondRowData = driver.findElement(By.xpath("//*[@id='someTable']/tr[2]/td[3]")).getText();
					
					if(firstRowData.equals("USA") && secondRowData.equals("USA"))
						System.out.println("Test Case 3 Passed with the search data USA");
					else
						System.out.println("Test Case 3 Failed with the search data USA");
				}
				else
					System.out.println("Test Case 3 Failed with the search data USA");
			}
			else if(checkRowCount == 4)
			{
				List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));				
				int rowCount = rows.size();	
				
				if(rowCount == 4)
					System.out.println("Test Case 3 Passed with no search data");
				else
					System.out.println("Test Case 3 Failed with no search data");		
			}
		} 
		catch (Exception e) 
		{			
			System.out.println(e.getMessage());
		}	
	}
	
	//class for invoking the browser
	public void invokeBrowser() {
		try {
			
			System.setProperty("webdriver.chrome.driver","chromedriver");
					
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//navigates to the home page
			driver.get("file:///home/chilukuri/Desktop/myWindowsDrive/SravyaProject/AutomationChallengeIDC/index.html");
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//class that executes Test Case 1
	public void testCaseOne() {
		
		String name = "Pavani Amanchi";
		String city = "Hyderabad";
		
		String nameVal;
		String cityVal;
				
       	try {			
       			//click the open modal button
				driver.findElement(By.xpath("//div[@id='test-1-div']//button")).click();
				
				//Enter values for name and city
				
				driver.findElement(By.id("name")).sendKeys(name);
				
				driver.findElement(By.id("city")).sendKeys(city);
				
				//click the enter data button
				driver.findElement(By.id("enter")).click();
				
				//close the Modal
				driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='modal-footer']//button")).click();
				
				//get the values under open modal button
				nameVal = driver.findElement(By.id("nameVal")).getText();
				cityVal = driver.findElement(By.id("cityVal")).getText();
			
				//check the values under open modal button
				if(nameVal.equals(name) && cityVal.equals(city))
					System.out.println("Test case 1 passed");
				else
					System.out.println("Test case 1 failed");
		} 
       	catch (Exception e) 
       	{
       		System.out.println(e.getMessage());
		}       	
    }
	
	//class that executes Test Case 2
    public void testCaseTwo() {
    	
   	try {
   			//scroll page down in order to make Test2 div as visible
   			scrollPage(250);
			
			driver.findElement(By.xpath("//div[@class='dropdown']//button")).click();
		
			//search for the keyword angular
			driver.findElement(By.id("myInput")).sendKeys("angular");
			selectComboValue(1);
					
			//clear the search field
			driver.findElement(By.id("myInput")).clear();
			
			//enter ReactJs in search field
			driver.findElement(By.id("myInput")).sendKeys("ReactJs");
			
			//verify no option is available for the given input
			selectComboValue(2);	
		
			//clear the search box
			driver.findElement(By.id("myInput")).clear();
			
			//mouse click outside the textbox using Javascript in order to hide the searchbox
			WebElement divElement = driver.findElement(By.id("test-2-div"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", divElement);
		} 
       	catch (Exception e) 
       	{
       		System.out.println(e.getMessage());
		}       	
    }
    
    //class that executes Test Case 3
    public void testCaseThree()
    {
    	try {
   			//scroll page down in order to make Test2 div as visible
   			scrollPage(600);   			
			driver.findElement(By.id("searchMe")).sendKeys("USA");
			
			//verify table rows after search  
			verifyTableRow(2);
			driver.findElement(By.id("searchMe")).clear();
			driver.findElement(By.id("searchMe")).sendKeys(Keys.ARROW_DOWN);
			
			//verify table rows after clearing the search box
			verifyTableRow(4);			
		} 
       	catch (Exception e) 
       	{
       		System.out.println(e.getMessage());
		}       	
    }
    
  //Class that executes Test Case 4
    public void testCaseFour()
    {
    	try {
    			scrollPage(1000);
				//Actions class method to drag and drop 
				 //Actions builder = new Actions(driver);
				 
				 WebElement dragMeButton = driver.findElement(By.xpath("//*[@id=\"drag1\"]"));
				 
				 WebElement rectangleBox = driver.findElement(By.xpath("//*[@id=\"div1\"]"));
				
				 
				 //Javascript function for drag and drop
				 final String java_script =
				            "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
				            "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
				            "ction(format,data){this.items[format]=data;this.types.append(for" +
				            "mat);},getData:function(format){return this.items[format];},clea" +
				            "rData:function(format){}};var emit=function(event,target){var ev" +
				            "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
				            "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
				            "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
				            "'drop',tgt);emit('dragend',src);";

				    ((JavascriptExecutor)driver).executeScript(java_script, dragMeButton, rectangleBox);
				 
				 //verify text changed in to rectangle box 
				 String textTo = driver.findElement(By.xpath("//div[@id = 'div1']//button")).getText(); 
				 
				 //check the string is empty or not and display messages
				 if(textTo.equals("")) 
					 System.out.println("Test Case 4 Failed: Source couldn't be dropped to target as expected");
				 else 
					 System.out.println("Test Case 4 Passed: Source is dropped to target as expected");
		} 
    	catch (Exception e)
    	{
			System.out.println(e.getMessage());
		}
    }
    
    //Class that closes the browser
    public void closeBrowser() 
    {
    	driver.close();
    }

    
}
