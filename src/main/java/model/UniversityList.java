package model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "universities")
@XmlAccessorType(XmlAccessType.FIELD)
public class UniversityList {
    @XmlElement(name = "university")
    private List<University> universities;

    public UniversityList() {}

    public UniversityList(List<University> universities) {
        this.universities = universities;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }
}
