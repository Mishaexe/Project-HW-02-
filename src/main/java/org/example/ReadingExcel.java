package org.example;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadingExcel {
    private ReadingExcel(){
    }
    static List<Student> readStudent() {
        List<Student> studentList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream("C:\\Users\\henya\\module_gradle\\ProjectGradle\\src\\main\\resources\\universityInfo.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String universityId = row.getCell(1).getStringCellValue();
                String fullName = row.getCell(0).getStringCellValue();
                int currentCourseNumber = (int)row.getCell(2).getNumericCellValue();
                float avgExamScore = (float) row.getCell(3).getNumericCellValue();
                Student student = new Student(universityId, fullName, currentCourseNumber, avgExamScore);
                studentList.add(student);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return studentList;
    }

    static List<University> readUniversity() {
        List<University> universityList = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream("C:\\Users\\henya\\module_gradle\\ProjectGradle\\src\\main\\resources\\universityInfo.xlsx");
        Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String id = row.getCell(0).getStringCellValue();
                String fullName = row.getCell(1).getStringCellValue();
                String shortName = row.getCell(2).getStringCellValue();
                int yearOfFoundation = (int) row.getCell(3).getNumericCellValue();
                StudyProfile mainProfile = StudyProfile.valueOf(row.getCell(4).getStringCellValue());
                University university = new University(id, fullName, shortName, yearOfFoundation, mainProfile);
                universityList.add(university);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return universityList;
    }

}