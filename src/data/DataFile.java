package data;

import utilities.Xls_Reader;

public class DataFile {

	//logintest
	Xls_Reader d = new Xls_Reader("/Users/pardeeptank/Desktop/Testing/NikulTest.xlsx");
	   
	public String emailwithspecialchar = d.getCellData("Data1", 1, 4);
	public	String wrongemail = d.getCellData("Data1", 1, 3);
	public String wrongpass = d.getCellData("Data1", 2, 2);;
	public String specialcharErr = d.getCellData("Data1", 3, 5);
	public String emptyEmailErr = d.getCellData("Data1", 3, 4);
	public String emptyPasswordErr =d.getCellData("Data1", 4, 3);
	public String globalErr = d.getCellData("Data1", 4, 2);
}
// similarly we can keep all the data related to homeTest, addToCartTest, searhTest and etc...
// we make it public so we can read it in other classes
