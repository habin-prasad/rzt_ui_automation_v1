package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ExcelFileModifier {

    public static void writeToExcel(String result) throws Exception{
        Workbook workbook = null;
        String filePath= "/home/kajal/TestReport/TestSuits.xlsx";
        File fileName =new File(filePath);

        /*Initializing file Reader*/
        FileInputStream file=new FileInputStream(fileName);

        /* Initializing Workbook Selector/Reader based on file extension */
        if(filePath.endsWith("xlsx")){
            workbook = new XSSFWorkbook();
        }else if(filePath.endsWith("xls")){
            workbook = new HSSFWorkbook();
        }else{
            throw new Exception("invalid file name, should be xls or xlsx");
        }

        /* Initializing workbook sheet Reader*/
        Sheet sheet = workbook.getSheet("TestSuits");

        /*Fetching total No of Rows and columns*/
        int totalNoRows=sheet.getPhysicalNumberOfRows();
        int totalRows=sheet.getLastRowNum();
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        /*Initializing String array to store the no of columns and rows*/
        String inputData[][] = new String[totalNoRows][noOfColumns];

        OutputStream fileOut = new FileOutputStream("/home/kajal/TestReport/TestSuits.xlsx");
           workbook.write(fileOut);
          //  Sheet sheet = workbook.createSheet("TestSuits");
           // Sheet datatypeSheet = workbook.getSheetAt(0);
            //  Label data1 = new Label(0,0,result);

    }

    public static void main(String[] args)
    {
        try {
            writeToExcel("Pass");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
