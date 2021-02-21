package automationChallenge;

public class automationChallengeTestCases {

	public static void main(String[] args) {
		try {
			methods tcObj = new methods();
			tcObj.invokeBrowser();
			tcObj.testCaseOne();
			Thread.sleep(2000);	
			tcObj.testCaseTwo();
			Thread.sleep(2000);	
			tcObj.testCaseThree();
			Thread.sleep(2000);
			tcObj.testCaseFour();
			tcObj.closeBrowser();
		} 
		catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
