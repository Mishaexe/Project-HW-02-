package enums;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "studyProfile")
@XmlAccessorType(XmlAccessType.FIELD)

public enum StudyProfile {

    @XmlElement(name = "MEDICINE")
    MEDICINE("Медицина"),

    @XmlElement(name = "PHYSICS")
    PHYSICS("Физик"),

    @XmlElement(name = "LINGUISTICS")
    LINGUISTICS("Лингвист"),
    @XmlElement(name = "MATHEMATICS")
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
