package org.example;
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    public void writeStatisticsToExcel(List<Statistics> statistics, String filePath){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Статистика");

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);

        Row headerRow = sheet.createRow(0);

        Cell headerTrainingProfile = headerRow.createCell(0);
        headerTrainingProfile.setCellValue("Профиль обучения");
        headerTrainingProfile.setCellStyle(headerStyle);

        Cell headerAvgScoreForExam = headerRow.createCell(1);
        headerAvgScoreForExam.setCellValue("Средний балл за экзамен");
        headerAvgScoreForExam.setCellStyle(headerStyle);

        Cell headerNumberOfStudentsByProfile = headerRow.createCell(2);
        headerNumberOfStudentsByProfile.setCellValue("Количество студентов по профилю");
        headerNumberOfStudentsByProfile.setCellStyle(headerStyle);

        Cell headerNumberOfUniversitiesByProfile = headerRow.createCell(3);
        headerNumberOfUniversitiesByProfile.setCellValue("Количество университетов по профилю");
        headerNumberOfUniversitiesByProfile.setCellStyle(headerStyle);

        Cell headerNamesOfUniversities = headerRow.createCell(4);
        headerNamesOfUniversities.setCellValue("Названия университетов");
        headerNamesOfUniversities.setCellStyle(headerStyle);

        int rowNum = 1;

        for (Statistics stat : statistics){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(stat.getTrainingProfile());
            row.createCell(1).setCellValue(
                    stat.getAvgScoreForExam().map(BigDecimal::toPlainString).orElse("Н/Д")
            );
            row.createCell(2).setCellValue(stat.getNumberOfStudentsByProfile());
            row.createCell(3).setCellValue(stat.getNumberOfUniversitiesByProfile());
            row.createCell(4).setCellValue(stat.getNamesOfUniversities());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            workbook.write(fileOutputStream);
            System.out.println("Файл успешно сохранён" + filePath);
        } catch (IOException e){
            System.err.println("Ошибка при записи файла" + e.getMessage());
        }finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
