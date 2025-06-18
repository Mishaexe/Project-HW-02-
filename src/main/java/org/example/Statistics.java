package org.example;

import java.math.BigDecimal;
import java.util.Optional;

public class Statistics {
    private String trainingProfile;
    private Optional<BigDecimal> avgScoreForExam;
    private int numberOfStudentsByProfile;
    private int numberOfUniversitiesByProfile;
    private String namesOfUniversities;

    public Statistics(String trainingProfile, Optional<BigDecimal> avgScoreForExam, int numberOfStudentsByProfile, int numberOfUniversitiesByProfile, String namesOfUniversities) {
        this.trainingProfile = trainingProfile;
        this.avgScoreForExam = avgScoreForExam;
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
        this.namesOfUniversities = namesOfUniversities;
    }

    public String getTrainingProfile() {
        return trainingProfile;
    }

    public void setTrainingProfile(String trainingProfile) {
        this.trainingProfile = trainingProfile;
    }

    public Optional<BigDecimal> getAvgScoreForExam() {
        return avgScoreForExam;
    }

    public void setAvgScoreForExam(Optional<BigDecimal> avgScoreForExam) {
        this.avgScoreForExam = avgScoreForExam;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public void setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
    }

    public int getNumberOfUniversitiesByProfile() {
        return numberOfUniversitiesByProfile;
    }

    public void setNumberOfUniversitiesByProfile(int numberOfUniversitiesByProfile) {
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
    }

    public String getNamesOfUniversities() {
        return namesOfUniversities;
    }

    public void setNamesOfUniversities(String namesOfUniversities) {
        this.namesOfUniversities = namesOfUniversities;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "trainingProfile='" + trainingProfile + '\'' +
                ", avgScoreForExam=" + avgScoreForExam +
                ", numberOfStudentsByProfile=" + numberOfStudentsByProfile +
                ", numberOfUniversitiesByProfile=" + numberOfUniversitiesByProfile +
                ", namesOfUniversities='" + namesOfUniversities + '\'' +
                '}';
    }

}
