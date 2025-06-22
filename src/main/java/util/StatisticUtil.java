package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.logging.Logger;
import java.util.stream.Collectors;

public final class StatisticUtil {
    private static final Logger loggerStatisticUtil = Logger.getLogger(StatisticUtil.class.getName());
    private StatisticUtil() {
    }
    public static List<Statistics> generateStatistics(List<Student> studentsList, List<University> universityList){
        if (studentsList == null || universityList == null) {
            loggerStatisticUtil.severe("Ошибка: один из списков равен null. studentsList = " + studentsList +
                    ", universityList = " + universityList);
            throw new IllegalArgumentException("Входные данные не могут быть null");
        }
        Map<StudyProfile, List<University>> universityByProfile = universityList.stream()
                .collect(Collectors.groupingBy(University::getMainProfile));

        loggerStatisticUtil.fine("Получены университеты, сгруппированные по профилям. Всего профилей: " + universityByProfile.size());

        Map<String, List<Student>> studentsByUniversityId = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getUniversityId));

        loggerStatisticUtil.finer("Студенты сгруппированы по ID университета. Всего записей: " + studentsByUniversityId.size());

        return universityByProfile.entrySet().stream().map(entry -> {
           StudyProfile profile = entry.getKey();
           List<University> universities = entry.getValue();

           loggerStatisticUtil.finest("Обрабатываем профиль: " + profile);

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

            loggerStatisticUtil.finest("Сформирована статистика для профиля: " + profile);

            return new Statistics(
                    profile.toString(),
                    avgScore,
                    studentsList.size(),
                    universityList.size(),
                    uniName
            );
        })
                .filter(stat -> stat.getNumberOfStudentsByProfile() > 0 || stat.getAvgScoreForExam().isEmpty())
                .toList();
    }
}
