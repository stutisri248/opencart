package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name ="loginData")
	public String[][] getData() throws Exception{
		String path ="C:\\Users\\Stuti\\OneDrive\\Desktop\\opencart_login_data.xlsx";
		excelUtility xlutils = new excelUtility();
		int totalrows = xlutils.getRow(path, "Login_Data");
		int totalcols =  xlutils.getcell(path,  "Login_Data");
		String[][] loginData = new String[totalrows][totalcols];
		for(int i =1; i<=totalrows;i++) {
			for(int j =0; j<totalcols;j++) {
				loginData[i-1][j] = xlutils.getcelldata(path, "Login_Data", i, j);
			}
		}
		return loginData;
		
	}

}
