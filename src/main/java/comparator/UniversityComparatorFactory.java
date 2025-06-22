package comparator;

import enums.UniversityComparatorType;

public final class UniversityComparatorFactory {
    public static UniversityComparator getComparator(UniversityComparatorType type){
     return switch (type){
         case FULL_NAME -> new UniversityNameComparator();
         case GET_OF_FOUNDATION -> new UniversityGetOfFoundationComparator();
         default -> throw new IllegalArgumentException("Неизвестный тип компаратора, type" + type);
     };
    }
}
