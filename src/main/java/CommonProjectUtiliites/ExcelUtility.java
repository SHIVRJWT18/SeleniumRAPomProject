package CommonProjectUtiliites;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

  public FileInputStream fis;
  public XSSFWorkbook wb;
  public XSSFSheet sheet;
  public XSSFRow row;
  public XSSFCell cell;
  public CellStyle style;
  String Filepath;
  
  public ExcelUtility(String filepath)
  {
    this.Filepath = filepath;	  
  }
  
  public int getRowCount(String sheetname) 
  {
	try {  
	fis = new FileInputStream(Filepath);
	wb = new XSSFWorkbook(fis);
	sheet = wb.getSheet(sheetname);
	int rwcount = sheet.getLastRowNum();
	wb.close(); 
	fis.close();
	return rwcount;
   }
	catch (Exception e) {
		e.printStackTrace();
		return 0;
    }
  }
  
  public int getCellCount(String sheetname,int rownum) 
  {
	try {  
	fis = new FileInputStream(Filepath);
	wb = new XSSFWorkbook(fis);
	sheet = wb.getSheet(sheetname);
    row = sheet.getRow(rownum);
	int cellcount = row.getLastCellNum();
	wb.close(); 
	fis.close();
	return cellcount;
   }
	catch (Exception e) {
		e.printStackTrace();
		return 0;
    }
  }
  
  public String getCellData(String sheetname,int rwnum,int colnum)
  {
   try {  
   fis = new FileInputStream(Filepath);
   wb = new XSSFWorkbook(fis);
   sheet = wb.getSheet(sheetname); 
   row = sheet.getRow(rwnum);
   cell = row.getCell(colnum);
   DataFormatter formatter = new DataFormatter();
   String data = formatter.formatCellValue(cell);
   wb.close();
   fis.close();
   return data;
  } 
   catch (Exception e) {
    e.printStackTrace();
    return "";
  }
   
  }
}
