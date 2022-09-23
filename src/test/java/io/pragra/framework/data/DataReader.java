package io.pragra.framework.data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataReader {
    private  Workbook workbook;
    private static DataReader dataReader;
    private DataReader() {
        try {
            InputStream stream = new FileInputStream("/Users/atin/Desktop/MasterData.xlsx");
            workbook = new XSSFWorkbook(stream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static   List<List<Object>> getKeyWordsFromSheet() {
        if(dataReader==null){
            dataReader = new DataReader();
        }
        Sheet sheet = dataReader.workbook.getSheet("TestCases");
        Iterator<Row> rowIterator = sheet.rowIterator();
        List<List<Object>> data = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            List<Object> cellData = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType()== CellType.STRING) {
                    cellData.add(cell.getStringCellValue());
                }
                if (cell.getCellType()== CellType.NUMERIC) {
                    cellData.add(cell.getNumericCellValue());
                }
            }
            data.add(cellData);

        }
        return data;

    }
}
