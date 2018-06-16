package utilities2;

import java.util.ArrayList;

public class DataFromExcel {
static Xls_Reader reader;
	
	public static  ArrayList<Object[]> getdata() {
	ArrayList<Object[]> myData = new ArrayList<Object[]>();	
	
	try {
		reader = new Xls_Reader System.getProperty("User.dir")+"");
	} catch(Exception e) {
		e.printStackTrace();
	}
for(int rowNum = 2; rowNum<= reader.getRowCount("Sheet1"); rowNum++) {
	String firstName = reader.getCellData("Sheet1","FirstName" , rowNum);
	String lastName = reader.getCellData("Sheet1","LastName" , rowNum);
	String emailaddress = reader.getCellData("Sheet1","Emailaddress" , rowNum);
	String password = reader.getCellData("Sheet1","Password" , rowNum);
Object data[] = {firstName,lastName,emailaddress,password};
myData.add(data);

}
	
	return myData;
}
}

}
