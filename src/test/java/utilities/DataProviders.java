package utilities;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path="./testData/Logintest_Data.xlsx";
		ExcelUtility util= new ExcelUtility(path);
		
		int rowCount=util.getRowCount("Sheet1");
		int  colCount=util.getCellCount("Sheet1", 1);
		
		String[][] logindata=new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				logindata[i-1][j]=util.getCellData("Sheet1", i, j);
				 System.out.println("Read Excel Data [" + (i-1) + "][" + j + "]: " + logindata[i - 1][j]);
			}
		}
		 System.out.println("✅ Excel Loaded from: " + new File(path).getAbsolutePath());
		
		return logindata;
		
		
		
	}
}
