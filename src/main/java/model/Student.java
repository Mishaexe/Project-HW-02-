package model;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlElement(name = "studentName")
    @SerializedName("Full name student")
    private String fullName;

    @XmlElement(name = "universityId")
    @SerializedName("Number university")
    private String universityId;

    @XmlTransient
    @SerializedName("Current Course Number")
    private int currentCourseNumber;

    @XmlElement(name = "avgScore")
    @SerializedName("The average value exam score")
    private double avgExamScore;

    public Student(){

    }
    public Student(String fullName, String universityId, int currentCourseNumber, double avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return "Студент" +
                " ФИО: " + fullName +
                ", Номер университета " + universityId +
                ", Номер курса " + currentCourseNumber +
                ", Средний показатель на экзамене " + avgExamScore;
    }

}
