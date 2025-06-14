package org.example;

import org.apache.commons.lang3.StringUtils;

public class UniversityNameComparator implements UniversityComparator{

    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getFullName(), u2.getFullName());
    }
}
