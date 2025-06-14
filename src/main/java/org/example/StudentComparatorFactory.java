package org.example;

public final class StudentComparatorFactory {

    public static StudentComparator getComparator(StudentComparatorType type){
        return switch (type){
            case AVG_SCORE -> new StudentAvgComparator();
            case FULL_NAME -> new StudentNameComparator();
            default -> throw new IllegalArgumentException("Неизвестный тип: type" + type);
        };
    }
}
