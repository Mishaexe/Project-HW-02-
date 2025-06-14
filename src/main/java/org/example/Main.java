package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args)  {
        List<Student> students = ReadingExcel.readStudent();
        List<University> universities = ReadingExcel.readUniversity();
        StudentComparator studentAVGComparator = StudentComparatorFactory.getComparator(StudentComparatorType.AVG_SCORE);
        StudentComparator studentNameComparator = StudentComparatorFactory.getComparator(StudentComparatorType.FULL_NAME);

        UniversityComparator universityNameComparator = UniversityComparatorFactory.getComparator(UniversityComparatorType.FULL_NAME);
        UniversityComparator universityGetOfFoundationComparator = UniversityComparatorFactory.getComparator(UniversityComparatorType.GET_OF_FOUNDATION);

        List<Student> sortedStudent = students.stream().sorted(studentAVGComparator).toList();
        sortedStudent.forEach(System.out::println);

        List<University> sortedUniversity = universities.stream().sorted(universityNameComparator).toList();
        sortedUniversity.forEach(System.out::println);
        }

}

