package com.learn.java.poi;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by grijesh on 2/5/16.
 */
public class DynamicChart {

    public static void main(String[] args) throws IOException {
        //Read the template
        FileInputStream input_document = new FileInputStream(new File("/home/grijesh/Downloads/Chart-Template.xlsx"));
        //Access the workbook
        XSSFWorkbook my_xls_workbook = new XSSFWorkbook(input_document);

        //Access the worksheet, so that we can update / modify it.
        XSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);

        updateWorksheet(my_worksheet);

        //Close the InputStream
        input_document.close();
        //Open FileOutputStream to write updates
        FileOutputStream output_file =new FileOutputStream(new File("/home/grijesh/Downloads/Chart-Template-Updated.xlsx"));
        //write changes
        my_xls_workbook.write(output_file);
        //close the stream
        output_file.close();
    }


    public static void updateWorksheet(XSSFSheet workSheet){
        List<String> monthList = getMonthList();
        for(int row =1 ; row< 13; row++){
            XSSFRow xssfRow = workSheet.createRow(row);
            xssfRow.createCell(0).setCellValue(monthList.get(row-1));
            xssfRow.createCell(1).setCellValue(row*10);
            xssfRow.createCell(2).setCellValue(row*5);
        }

    }

    public static List<String> getMonthList(){
        List<String> monthList = new LinkedList<>();
        monthList.add("January");
        monthList.add("February");
        monthList.add("March");
        monthList.add("April");
        monthList.add("May");
        monthList.add("June");
        monthList.add("July");
        monthList.add("August");
        monthList.add("September");
        monthList.add("October");
        monthList.add("November");
        monthList.add("December");
        return monthList;
    }



}
