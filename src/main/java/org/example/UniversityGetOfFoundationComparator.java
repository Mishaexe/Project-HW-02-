package org.example;

public class UniversityGetOfFoundationComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(),o2.getYearOfFoundation());
    }
}
