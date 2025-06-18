package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public final class StatisticUtil {
    private StatisticUtil() {
    }
    public static List<Statistics> generateStatistics(List<Student> studentsList, List<University> universityList){
        if (studentsList == null || universityList == null) {
            throw new IllegalArgumentException("Входные данные не могут быть null");
        }
        Map<StudyProfile, List<University>> universityByProfile = universityList.stream()
                .collect(Collectors.groupingBy(University::getMainProfile));

        Map<String, List<Student>> studentsByUniversityId = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getUniversityId));


        return universityByProfile.entrySet().stream().map(entry -> {
           StudyProfile profile = entry.getKey();
           List<University> universities = entry.getValue();

           List<Student> students = universities.stream()
                   .flatMap(u -> studentsByUniversityId.getOrDefault(u.getId(), Collections.emptyList()).stream()).toList();

            Optional<BigDecimal> avgScore = students.isEmpty() ? Optional.empty() :
                    Optional.of(
                            BigDecimal.valueOf(
                                    students.stream()
                                            .mapToDouble(Student::getAvgExamScore)
                                            .average()
                                            .orElse(0.0)
                            ).setScale(2, RoundingMode.HALF_UP)
                    );
            String uniName = universities.stream().map(University::getShortName)
                    .collect(Collectors.joining(", "));


            return new Statistics(
                    profile.toString(),
                    avgScore, //тут подчеркнуто красным
                    studentsList.size(),
                    universityList.size(),
                    uniName
            );
        })
                .filter(stat -> stat.getNumberOfStudentsByProfile() > 0 || stat.getAvgScoreForExam().isEmpty())
                .toList();
    }
}
