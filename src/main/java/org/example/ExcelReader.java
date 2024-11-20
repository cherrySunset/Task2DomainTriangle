package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelReader {

    public static List<Object[]> readTriangleData(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                int a = (int) row.getCell(0).getNumericCellValue();
                int b = (int) row.getCell(1).getNumericCellValue();
                int c = (int) row.getCell(2).getNumericCellValue();
                String type = row.getCell(3).getStringCellValue();

                data.add(new Object[]{a, b, c, type});
            }
        }

        return data;
    }
}
