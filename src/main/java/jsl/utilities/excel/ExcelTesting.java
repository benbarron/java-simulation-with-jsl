/*
 * Copyright (c) 2018. Manuel D. Rossetti, rossetti@uark.edu
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsl.utilities.excel;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import jsl.utilities.reporting.JSL;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author rossetti
 */
public class ExcelTesting {

    public static Path excelDir = JSL.ExcelDir;

//    public static Path excelDir = Paths.get(".", "jsl/utilities/excel");
    final static Logger logger = ExcelUtil.LOG;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException  {
//        createWorkBookTest("testworkbook");
       readWorkBookTest("testworkbook");
//        writeSheetAsCSVTest();
//        writeWorkbookAsCSVTest();

    }


    /**
     * Creates an Excel workbook in the current working directory with the
     * provided name and writes some things to its first sheet
     *
     * @param wbName the name of the workbook
     */
    public static void createWorkBookTest(String wbName) {
        System.out.println("Creating " + wbName + " .... ");
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row createRow = sheet.createRow(0);
        Cell createCell = createRow.createCell(0);
        createCell.setCellValue(999.99);
        //Create file system using specific name
        for (int i = 1; i <= 10; i++) {
            sheet.createRow(i).createCell(0).setCellValue(i);
        }
        FileOutputStream out;
        String name = wbName + ".xlsx";
        Path wbPath = excelDir.resolve(name);
        try {
            out = new FileOutputStream(new File(wbPath.toString()));
            //write operation workbook using file out object
            workbook.write(out);
            out.close();
            workbook.close();
        } catch (FileNotFoundException ex) {
            logger.error("Error in createWorkBookTest()", ex);
        } catch (IOException ex) {
            logger.error("Error in writeColonialDBToExcel()", ex);
        }

        System.out.println(name + " created successfully.");
    }

    /**
     * Tests the opening of a workbook in the current working directory with the
     * supplied name reading from its first sheet.
     *
     * @param wbName
     */
    public static void readWorkBookTest(String wbName) {
        System.out.println("Reading from " + wbName + " .... ");
        String name = wbName + ".xlsx";
        Path wbPath = excelDir.resolve(name);
        try {
            OPCPackage pkg = OPCPackage.open(new File(wbPath.toString()));
            XSSFWorkbook wb = new XSSFWorkbook(pkg);
            XSSFSheet sheet = wb.getSheet("Sheet1");
            for (int i = 0; i < 11; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell = row.getCell(0);
                System.out.println(cell.getRawValue());
            }

            //pkg.close();
            wb.close();
        } catch (InvalidFormatException | IOException ex) {
            logger.error("Error in readWorkBookTest()", ex);
        }
        System.out.println(name + " read successfully.");

    }

    /**
     * Tests the writing an Excel sheet to a comma separated value file.
     * Depends on having ColonialTemp.xlsx in the current working directory
     */
    public static void writeSheetAsCSVTest() throws IOException {
        Path path = excelDir.resolve("ColonialTemp.xlsx");
        ExcelWorkbookAsCSV excelWorkbookAsCSV = new ExcelWorkbookAsCSV(path);
        excelWorkbookAsCSV.writeXSSFSheetToCSV("PRODUCT");
    }

    /**
     * Tests the writing an Excel workbook to a set of comma separated value files.
     * Depends on having ColonialTemp.xlsx in the current working directory
     * Writes to a directory called excelOutput in the current working directory
     */
    public static void writeWorkbookAsCSVTest() throws IOException {
        Path path = excelDir.resolve("ColonialTemp.xlsx");
        ExcelWorkbookAsCSV excelWorkbookAsCSV = new ExcelWorkbookAsCSV(path);
        excelWorkbookAsCSV.writeXSSFWorkbookToCSV(Paths.get(".", "excelOutput"));
    }
}
