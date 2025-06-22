package org.example;
import java.math.BigDecimal;


import model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


public class XlsWriter {
    private static final Logger loggerXlsWriter = Logger.getLogger(XlsWriter.class.getName());
    public void writeStatisticsToExcel(List<Statistics> statistics, String filePath){
        loggerXlsWriter.info("Начинаем запись статистики в Excel");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Статистика");
        loggerXlsWriter.fine("Создан лист: " + sheet.getSheetName());

        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);
        loggerXlsWriter.info("Создан стиль таблицы");

        Row headerRow = sheet.createRow(0);
        loggerXlsWriter.info("Создана ряд заголовков");

        Cell headerTrainingProfile = headerRow.createCell(0);
        headerTrainingProfile.setCellValue("Профиль обучения");
        headerTrainingProfile.setCellStyle(headerStyle);
        loggerXlsWriter.info("Указана 1 ячейка " + headerTrainingProfile.getStringCellValue());

        Cell headerAvgScoreForExam = headerRow.createCell(1);
        headerAvgScoreForExam.setCellValue("Средний балл за экзамен");
        headerAvgScoreForExam.setCellStyle(headerStyle);
        loggerXlsWriter.info("Указана 2 ячейка " + headerAvgScoreForExam.getStringCellValue());

        Cell headerNumberOfStudentsByProfile = headerRow.createCell(2);
        headerNumberOfStudentsByProfile.setCellValue("Количество студентов по профилю");
        headerNumberOfStudentsByProfile.setCellStyle(headerStyle);
        loggerXlsWriter.info("Указана 3 ячейка " + headerNumberOfStudentsByProfile.getStringCellValue());

        Cell headerNumberOfUniversitiesByProfile = headerRow.createCell(3);
        headerNumberOfUniversitiesByProfile.setCellValue("Количество университетов по профилю");
        headerNumberOfUniversitiesByProfile.setCellStyle(headerStyle);
        loggerXlsWriter.info("Указана 4 ячейка " + headerNumberOfUniversitiesByProfile.getStringCellValue());

        Cell headerNamesOfUniversities = headerRow.createCell(4);
        headerNamesOfUniversities.setCellValue("Названия университетов");
        headerNamesOfUniversities.setCellStyle(headerStyle);
        loggerXlsWriter.info("Указана 5 ячейка " + headerNamesOfUniversities.getStringCellValue());

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
        loggerXlsWriter.info("Статистика успешно записана в Excel. Всего записано строк: " + (rowNum - 1));

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            workbook.write(fileOutputStream);
            loggerXlsWriter.info("Файл успешно сохранён" + filePath);
        } catch (IOException e){
            loggerXlsWriter.severe("Ошибка при записи файла" + e.getMessage());
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
