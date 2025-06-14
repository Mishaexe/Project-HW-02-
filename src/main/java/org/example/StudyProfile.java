package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PHYSICS("Физик"),

    LINGUISTICS("Лингвист"),
    MATHEMATICS("Математическое");
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
