package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;


public class ExcelFileModifier {

    public static Cell cell;
    public static Workbook workbook;
    public static Sheet sheet;
    public static Row row;
    public static int noOfColumns;
    static int totalRowsCount;
    static java.util.Date date;
    static String excelFilePath;
    static int count=1;

    public ExcelFileModifier()  {

        excelFilePath = "/home/kajal/TestReport/TestSuits.xlsx";
        /*..Initializing file Reader.*/
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(excelFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*Factory for creating the appropriate kind of Workbook (be it HSSFWorkbook or XSSFWorkbook), by auto-detecting from the supplied input.*/
        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        /* Initializing workbook sheet Reader*/
        sheet = workbook.getSheetAt(0);
        /*Fetching total No of Rows and columns*/
        /*int totalPhysicalRows = sheet.getPhysicalNumberOfRows();*/
        totalRowsCount = sheet.getLastRowNum();
        System.out.println(totalRowsCount);
        noOfColumns = sheet.getRow(0).getLastCellNum();

        /*Creating instance for current date and time*/
        date = new java.util.Date(System.currentTimeMillis());
        /*Create new cell in first row i.e header*/
        row = sheet.getRow((short) 0);
        row.createCell(noOfColumns).setCellValue("Executed on " + date);
        sheet.autoSizeColumn(noOfColumns);
    }

    public static void updateResultColumn(boolean result, String methodName) {

        // String testCase = searchTestCase();
       // if(methodName.equalsIgnoreCase(testCase)) {

            //get Row address

            sheet.getRow(count).createCell(noOfColumns).setCellValue(String.valueOf(result));
            count = count + 1;
            try {
                updateExcel();
                System.out.println("Updated Successfully.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        //}
    }

    protected static void updateExcel() throws FileNotFoundException {
            /*For writing data into excel.*/
            OutputStream testOutput = new FileOutputStream(new File(excelFilePath));
            try {
                workbook.write(testOutput);
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    testOutput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    /* ..Read the Excel*/
    public static void readExcelFile()throws Exception{

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
    }

    public static void searchTestCase()  {


    }


        /*..search the method name inside testcase column..*//*..Get row number of that testcase...*/
    public static void searchColumnTestCase(){




    }




        /*return row number
        */

    /*
    public static void main(String[] args)
    {
        try {
            ExcelFileModifier createcolumn= new ExcelFileModifier();
            updateResultColumn(true);
            updateExcel();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }..*/
}