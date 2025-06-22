package org.example;

import enums.StudyProfile;
import model.*;
import util.StatisticUtil;

import javax.xml.bind.annotation.XmlElement;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger loggerMain = Logger.getLogger(Main.class.getName());
    public static void main(String[] args)  {
        

//        List<Student> students =  ReadingExcel.readStudent();
//        students.stream()
//                .map(JsonUtil::studentToJson)
//                .peek(System.out::println)
//                .map(JsonUtil::jsonToStudent)
//                .forEach(System.out::println);
//        List<University> universities = ReadingExcel.readUniversity();
//        universities.stream()
//                .map(JsonUtil::universityToJson)
//                .peek(System.out::println)
//                .map(JsonUtil::jsonToUniversity)
//                .forEach(System.out::println);
//        StudentComparator studentAVGComparator = StudentComparatorFactory.getComparator(StudentComparatorType.AVG_SCORE);
//        StudentComparator studentNameComparator = StudentComparatorFactory.getComparator(StudentComparatorType.FULL_NAME);
//
//        UniversityComparator universityNameComparator = UniversityComparatorFactory.getComparator(UniversityComparatorType.FULL_NAME);
//        UniversityComparator universityGetOfFoundationComparator = UniversityComparatorFactory.getComparator(UniversityComparatorType.GET_OF_FOUNDATION);

        //List<Student> sortedStudent = students.stream().sorted(studentAVGComparator).toList();
        //sortedStudent.forEach(System.out::println);

        //List<University> sortedUniversity = universities.stream().sorted(universityNameComparator).toList();
        //sortedUniversity.forEach(System.out::println);

//        String jsonStudents = JsonUtil.studentListToJson(students);
//        System.out.println(jsonStudents);
//
//        String jsonUniversity = JsonUtil.universityListToJson(universities);
//        System.out.println(jsonUniversity);

//        Type listTypeStudent = new TypeToken<List<Student>>(){}.getType();
//        List<Student> deserializedStudents = JsonUtil.jsonToStudentList(jsonStudents, listTypeStudent);
//        for (Student student : deserializedStudents){
//            System.out.println(student);
//        }
//
//        Type listTypeUniversity = new TypeToken<List<University>>(){}.getType();
//        List<University> deserializedUniversity = jsonToUniversityList(jsonUniversity, listTypeUniversity);
//        for (University university : deserializedUniversity){
//            System.out.println(university);
//        }
//
//        if (students.size() == deserializedStudents.size() || universities.size() == deserializedUniversity.size()){
//            System.out.println("Количество совпадает");
//        }else {
//            System.out.println("Не совпадает");
//        }


        try (InputStream config = Main.class.getClassLoader()
                .getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(config);
        } catch (IOException e) {
            System.err.println("Could not load logging configuration");
            e.printStackTrace();
        }

        loggerMain.info("Начата работа в Main");

        University u1 = new University("1", "Московский государственный университет", "МГУ", 1755, StudyProfile.MEDICINE);
        University u2 = new University("2", "Санкт-Петербургский университет", "СПбГУ", 1819, StudyProfile.MATHEMATICS);
        University u3 = new University("3", "Российская академия права", "РАП", 1990, StudyProfile.PHYSICS);
        loggerMain.info("Создано 3 Университета");

        Student s1 = new Student("Иван Петров", "1", 3, 4.7);
        Student s2 = new Student("Анна Смирнова", "2", 2, 4.2);
        Student s3 = new Student("Олег Волков", "1", 4, 4.9);
        Student s4 = new Student("Екатерина Орлова", "3", 1, 3.8);
        loggerMain.info("Создано 4 студента");

        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        StudentList studentList = new StudentList(students);

        List<University> universities = Arrays.asList(u1, u2, u3);
        UniversityList universityList = new UniversityList(universities);
        loggerMain.info("Создалось 2 списка (Студент, университет)");

        loggerMain.fine("Студенты" + students);
        loggerMain.fine("Университет" + universities);

        loggerMain.info("Начата генерация статистики");
        List<Statistics> stats = StatisticUtil.generateStatistics(students, universities);
        loggerMain.info("Генерация статистики завершена");

        if (stats.isEmpty()) {
            loggerMain.severe("Сгенерированная статистика пуста!");
        } else {
            loggerMain.info("Сформировано записей статистики: " + stats.size());
        }

        XmlWriter xmlWriter = new XmlWriter();

        xmlWriter.writeXmlToFile(studentList, "student");
        loggerMain.info("Создан xml файл student");
        xmlWriter.writeXmlToFile(universityList, "universities");
        loggerMain.info("Создан xml файл universities");
        JsonWriter jsonWriter = new JsonWriter();

        jsonWriter.writeJsonToFile(studentList, "students");
        loggerMain.info("Создан JSON файл students");
        jsonWriter.writeJsonToFile(universityList, "university");
        loggerMain.info("Создан JSON файл students");
//        XlsWriter xlsWriter = new XlsWriter();
//        xlsWriter.writeStatisticsToExcel(stats, "src/main/resources/statistics.xlsx");
//        loggerMain.info("создан XLSX файл ");


    }
}

