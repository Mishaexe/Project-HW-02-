package org.example;

import com.google.gson.annotations.SerializedName;

public class University {

    @SerializedName("Id")
    private String id;

    @SerializedName("University_name")
    private String fullName;

    @SerializedName("short_university_name")
    private String shortName;

    @SerializedName("Year_of_foundation")
    private int yearOfFoundation;

    @SerializedName("Profile direction")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "Университет" +
                ", Номер университета " + id +
                ", Полное имя университета " + fullName +
                ", аббревиатура " + shortName +
                ", год Основания " + yearOfFoundation +
                ", основной профиль " + mainProfile;
    }

}
