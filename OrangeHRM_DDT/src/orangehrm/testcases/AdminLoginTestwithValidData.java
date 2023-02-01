package orangehrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLUtils;

public class AdminLoginTestwithValidData extends AppUtils
{

	String datafile =  "C:\\Users\\RamaKrishna\\OneDrive\\Desktop\\TestData.xlsx";
	String datasheet = "AdminLoginValidData";
	
	@Test
	public void checkAdminLogin() throws IOException
	{
		
		int rowcount;		
		rowcount = XLUtils.getRowCount(datafile, datasheet);
		
		String uid,pwd;		
		LoginPage lp = new LoginPage();
		
		for(int i=1;i<=rowcount;i++)
		{
			uid = XLUtils.getStringCellData(datafile, datasheet, i, 0);
			pwd = XLUtils.getStringCellData(datafile, datasheet, i, 1);
			lp.login(uid, pwd);
			boolean res = lp.isAdminModuleDisplayed();
			Assert.assertTrue(res);
			if(res)
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Pass");
				XLUtils.fillGreenColor(datafile, datasheet, i, 2);
				lp.logout();
			}else
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}		
			
		}
	}	
	
}
