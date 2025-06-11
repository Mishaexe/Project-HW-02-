package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PROGRAMIST("Программист"),

    SVARSHIK("Сварщик");
    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
    @Override
    public String toString() {
        return profileName;
    }
}
