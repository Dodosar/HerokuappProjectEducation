package login;

import org.testng.annotations.DataProvider;

public class DPclass {
	
	@DataProvider(name = "log-in-data")
	public Object [] [] logInData(){
		Object [][] data = new Object [2][2];
		
		data [0][0] = "tomsmith" ; data [0][1] = "SuperSecretPassword!";
		
		data [1][0] = "tomsmith" ; data [1][1] = "SuperSecretPassword!";
		return data;
	}
}
